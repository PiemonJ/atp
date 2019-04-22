package com.bytedance.atp.domain.model.group;

import com.bytedance.atp.common.Category;
import com.bytedance.atp.domain.model.AggregateRoot;
import com.bytedance.atp.common.Rule;
import com.bytedance.atp.domain.model.group.event.RuleGroupChangedEvent;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Document
public class RuleGroup extends AggregateRoot {


    GroupIdentifier groupIdentifier;

    GroupMetaData groupMetaData;
    //为简单起见，规则组容纳各种类别的规则
    public List<Rule> rules;


    public RuleGroup(GroupIdentifier groupIdentifier, GroupMetaData groupMetaData, List<Rule> rules) {
        this.groupIdentifier = groupIdentifier;
        this.groupMetaData = groupMetaData;
        this.rules = rules;
    }

    public void rebuild(List<Rule> rules){


        this.events.add(
                new RuleGroupChangedEvent(
                        groupIdentifier.getGitlab(),
                        getId(),
                        rules));
        this.rules = rules;
    }

    public RuleGroupPile ruleGroupOfSpecCategory(Category category){


        List<Rule> filteredRules = rules.stream().filter(rule -> rule.getCategory() == category)
                .collect(Collectors.toList());

        String gitlab = groupIdentifier.getGitlab();


        return new RuleGroupPile(gitlab,category,filteredRules);
    }

}
