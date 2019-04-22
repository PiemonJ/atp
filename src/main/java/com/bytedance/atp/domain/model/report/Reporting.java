package com.bytedance.atp.domain.model.report;

import com.bytedance.atp.common.State;
import com.bytedance.atp.domain.model.AggregateRoot;
import com.bytedance.atp.common.Tuple2;
import com.bytedance.atp.common.Rule;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * 报表
 *
 */
@Setter
@Getter
@Document
@NoArgsConstructor
@AllArgsConstructor
public class Reporting extends AggregateRoot{

    public String ruleGroupId;

    public String flowId;

    public Clock clock;

    public List<Tuple2<Rule,Boolean>> detail = new ArrayList<>();

    public boolean whetherInterrupt;

    public boolean whetherTrap;

    public boolean whetherTerminal;


    public boolean whetherStateFinal(){
        return whetherTerminal || whetherTrap || whetherInterrupt;
    }


    public void rich(Rule rule,State state,boolean whetherMatched){
        switch (state){
            case RUNNING:
                detail.add(Tuple2.apply(rule,whetherMatched));
                break;
            case TRAP:
                detail.add(Tuple2.apply(rule,false));
                whetherTrap = true;
                break;
            case INTERRUPT:
                whetherInterrupt = true;
                break;
            case DONE:
                whetherTerminal = true;
                break;
            case PAUSE:
                break;
            case READY:
                break;



        }

    }

}
