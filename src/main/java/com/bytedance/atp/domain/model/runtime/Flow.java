package com.bytedance.atp.domain.model.runtime;

import com.bytedance.atp.domain.model.AggregateRoot;
import com.bytedance.atp.domain.model.common.*;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.Subject;
import lombok.*;
import org.apache.catalina.core.ApplicationContext;
import org.reactivestreams.Publisher;
import org.springframework.context.ApplicationEventPublisher;

import java.nio.channels.Channel;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 *
 * Runtime 不入库，仅仅代表一个运行时的流程
 */

@Setter
@Getter
@NoArgsConstructor
public class Flow {

    public String flowId;

    public String groupId;

    //任务流执行策略
    public ExeStrategy exeStrategy;

    public State state = State.RUNNING;

    public OperatorChain chain;

    //流程控制
    public Subject<FlowMeddleEvent> meddle;
    //Spring上下文
    public ApplicationEventPublisher bus;

    public Disposable disposable;

    public Flow(ExeStrategy exeStrategy, State state, OperatorChain chain, Subject<FlowMeddleEvent> meddle, ApplicationEventPublisher bus) {
        this.flowId = UUID.randomUUID().toString();
        this.exeStrategy = exeStrategy;
        this.state = state;
        this.chain = chain;
        this.meddle = meddle;
        this.bus = bus;
        listen();

    }

    public void listen(){
        disposable = meddle.filter(
                event -> event.flowId.equals(flowId) || event.groupId.equals(groupId)
        ).subscribe(
                event -> stateChanger(event.from, event.to)
        );
    }

    /**
     * 将执行的逻辑，委派到状态上
     */
    public void run(){
        try {
            while (chain.hasNext()){
                if (state == State.RUNNING){
                    Operator operator = chain.next();
                    if (!operator.action().ok()){
                        bus.publishEvent(new RuleNonMatchedEvent());
                        switch (exeStrategy){
                            case FAIL_FAST:
                                bus.publishEvent(new RuleInterruptedEvent());
                                break;
                            case THROUGHOUT:
                                continue;
                        }
                    } else {
                        bus.publishEvent(new RuleMatchedEvent());
                    }
                } else if (state == State.PAUSE){
                    //自旋
                    do { } while (state == State.PAUSE);

                } else {
                    bus.publishEvent(new RuleInterruptedEvent());
                    break;
                }

            }

            if (state == State.RUNNING){

                stateChanger(State.RUNNING,State.DONE);

                bus.publishEvent(new RuleTerminalEvent());
            }
        } catch (Exception e){

        } finally {
            disposable.dispose();
        }
    }

    public synchronized void stateChanger(State from , State to){
        if (this.state == from){
            this.state = to;
        }
    }


}
