package com.bytedance.atp.domain.model.cc;

import com.bytedance.atp.domain.model.AggregateRoot;
import com.bytedance.atp.domain.model.group.RuleCategory;
import lombok.Data;

/**
 * 规则组的配置中心
 */

@Data
public class ConfigCenter extends AggregateRoot {

    public String ruleGroupId;

    public BuildInfo buildInfo;

    public ReleaseInfo releaseInfo;

    public CodeInfo codeInfo;

    public Info obtainConfigInfo(RuleCategory category){

        switch (category){
            case CODE:
                return codeInfo;
            case BUILD:
                return buildInfo;
            case RELEASE:
                return releaseInfo;
        }
        return null;

    }
}
