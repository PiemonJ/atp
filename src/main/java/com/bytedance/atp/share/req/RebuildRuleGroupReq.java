package com.bytedance.atp.share.req;

import com.bytedance.atp.common.Rule;
import lombok.Data;

import java.util.List;

@Data
public class RebuildRuleGroupReq {

    String ruleGroupId;

    String groupName;

    List<Rule> rules;


}
