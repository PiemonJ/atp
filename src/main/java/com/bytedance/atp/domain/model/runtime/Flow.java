package com.bytedance.atp.domain.model.runtime;

import com.bytedance.atp.common.*;
import com.bytedance.atp.domain.model.runtime.event.FlowEventFactory;
import com.bytedance.atp.domain.model.runtime.event.FlowMeddleEvent;
import io.reactivex.disposables.Disposable;
import io.reactivex.processors.PublishProcessor;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.annotation.Transient;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

/**
 *
 * Runtime 不入库，仅仅代表一个运行时的流程
 */
@Slf4j
@Setter
@Getter
@NoArgsConstructor
public class Flow {

    public String flowId;

    public String groupId;

    public Env env;

    public Category category;

    //任务流执行策略
    public ExeStrategy exeStrategy;

    public AtomicReference<State> state;

    public OperatorChain chain;

    //流程控制
    @Transient
    public PublishProcessor<FlowMeddleEvent> meddle;
    //Spring上下文
    @Transient
    public ApplicationEventPublisher bus;

    public Disposable disposable;

    public Flow(String groupId, Category category,ExeStrategy exeStrategy, OperatorChain chain, PublishProcessor<FlowMeddleEvent> meddle, ApplicationEventPublisher bus) {
        this.flowId = UUID.randomUUID().toString();
        this.groupId = groupId;
        this.category = category;
        this.exeStrategy = exeStrategy;
        this.state = new AtomicReference<>(State.READY);
        this.chain = chain;
        this.meddle = meddle;
        this.bus = bus;
        listen();
    }


    public void listen(){

        disposable = meddle.filter(
                event -> event.getFlowId().equals(flowId) || event.getGroupId().equals(groupId)
        ).subscribe(
                event -> stateChanger(event.from,event.to)
        );

    }

    /**
     * 将执行的逻辑，委派到状态上
     *
     *
     * PS: Terminal事件标识着Flow的结束（无论如何，都会发送这个事件，以说明Flow执行流程的结束）
     *     Matched时间表示规则匹配
     *     Non-Matched表示规则不匹配
     *     Traped表示出现无法控制的陷阱/异常
     *     Interrupted表示被用户人工中断
     *
     */
    public void run(){
        stateChanger(State.READY,State.RUNNING);

        Rule rule = null;
        try {
            OperatorChain.OperatorChainIterator iterator = chain.iterator();
loop:       while (iterator.hasNext()){

                if (state.get() == State.RUNNING){

                    Operator operator = iterator.next();

                    rule = operator.getRule();

                    if (!operator.action().ok()){

                        bus.publishEvent(FlowEventFactory.withNonMatched(groupId,flowId,rule));

                        switch (exeStrategy){
                            case FAIL_FAST:
                                break loop;
                            case THROUGHOUT:
                                continue loop;
                        }
                    } else {

                        bus.publishEvent(FlowEventFactory.withMatched(groupId,flowId,rule));

                    }
                } else if (state.get() == State.PAUSE){
                    //自旋
                    do { } while (state.get() == State.PAUSE);

                } else if (state.get() == State.INTERRUPT){

                    bus.publishEvent(FlowEventFactory.withInterrupt(groupId,flowId));
                    break;

                } else if (state.get() == State.DONE){

                    break;
                }

            }

            if (state.get() == State.RUNNING){

                stateChanger(State.RUNNING,State.DONE);

            }



        } catch (Exception e){

            bus.publishEvent(FlowEventFactory.withTraped(groupId,flowId,rule));

            log.info(e.getMessage());

        } finally {

            bus.publishEvent(FlowEventFactory.withTerminal(groupId,flowId));

            disposable.dispose();
        }
    }

    public void stateChanger(State from , State to){

        state.compareAndSet(from,to);

    }


}
