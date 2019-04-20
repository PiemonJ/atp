package com.bytedance.atp.domain.model.group;

import com.bytedance.atp.domain.model.AggregateRoot;
import com.bytedance.atp.common.Rule;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Data
@Document
public class RuleGroup extends AggregateRoot {

    GroupIdentifier groupIdentifier;

    public List<Rule> rules;



    public RuleGroup(GroupIdentifier groupIdentifier, List<Rule> rules) {
        this.groupIdentifier = groupIdentifier;
        this.rules = rules;
    }




    public void rebuild(String groupName,List<Rule> rules){

        GroupIdentifier groupIdentifier = this.groupIdentifier.copyCreator(groupName);

        this.rules = rules;
    };


}
