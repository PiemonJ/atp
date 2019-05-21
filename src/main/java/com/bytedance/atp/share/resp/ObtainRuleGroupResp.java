package com.bytedance.atp.share.resp;

import com.bytedance.atp.common.Rule;
import com.bytedance.atp.domain.model.group.GroupIdentifier;
import com.bytedance.atp.domain.model.group.GroupMetaData;
import com.bytedance.atp.share.vo.RuleInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ObtainRuleGroupResp {


    public String gitlab;

    public String ruleGroupName;

    public String creator;

    public Date createTime;
    //为简单起见，规则组容纳各种类别的规则
    public List<RuleInfo> rules;
}
