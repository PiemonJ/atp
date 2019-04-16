package com.bytedance.atp;

import com.bytedance.atp.domain.model.group.Rule;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 针对某个规则，输出的该规则会用到的执行器运行时参数
 *
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConfigPile {

    public String ruleGroupId;

    public ConfigEnv env;

    public Rule rule;

    public List<Configers> configers;


}
