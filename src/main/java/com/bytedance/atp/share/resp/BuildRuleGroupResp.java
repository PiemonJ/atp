package com.bytedance.atp.share.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BuildRuleGroupResp {

    public String ruleGroupId;

    public boolean ok;


}
