package com.bytedance.atp.share.req;

import com.bytedance.atp.common.Rule;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BuildRuleGroupReq {

    public String creator;

    public String groupName;

    List<Rule> rules;
}
