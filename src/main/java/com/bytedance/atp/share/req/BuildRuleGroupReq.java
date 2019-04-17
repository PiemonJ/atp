package com.bytedance.atp.share.req;

import com.bytedance.atp.domain.model.group.Rule;
import lombok.Data;

import java.util.List;
@Data
public class BuildRuleGroupReq {

    public String creator;

    public String groupName;

    List<Rule> rules;
}
