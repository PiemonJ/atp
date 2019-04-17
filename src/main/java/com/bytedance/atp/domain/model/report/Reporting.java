package com.bytedance.atp.domain.model.report;

import com.bytedance.atp.domain.model.AggregateRoot;
import com.bytedance.atp.domain.model.common.Tuple2;
import com.bytedance.atp.domain.model.group.Rule;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

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

    public long ruleGroupId;

    public String flowId;

    public List<Tuple2<Rule,Boolean>> detail;

    public boolean whetherInterrupt;

    public boolean whetherTrap;

    public boolean whetherTerminal;


    public boolean whetherStateFinal(){
        return whetherTerminal || whetherTrap || whetherInterrupt;
    }


}
