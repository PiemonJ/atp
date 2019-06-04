package com.flute.atp.share.req;

import com.flute.atp.common.Rule;
import lombok.Data;

import java.util.List;

@Data
public class RebuildRuleGroupReq {

    String ruleGroupId;

    String groupName;

    List<Rule> rules;


}
