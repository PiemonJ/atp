package com.bytedance.atp.domain.model.report;

import com.bytedance.atp.domain.model.AggregateRoot;
import com.bytedance.atp.domain.model.common.Tuple2;
import com.bytedance.atp.domain.model.group.Rule;

import java.util.List;

/**
 * 报表
 *
 */
public class Reporting {

    public String ruleGroupId;

    public String flowId;

    public List<Tuple2<Rule,Boolean>> detail;

    public boolean whetherInterrupt;

    public boolean whetherTrap;

    public boolean whetherTerminal;


    public boolean whetherStateFinal(){
        return whetherTerminal || whetherTrap || whetherInterrupt;
    }


}
