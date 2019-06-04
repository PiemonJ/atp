package com.flute.atp.domain.model.cc;

import com.flute.atp.common.Rule;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

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

    public String gitlab;

    public Rule rule;

    public Map<ConfigDescriptor,Configer> configers;


    /**
     *
     *
     * @param descriptor
     * @param <T>
     * @return
     */

    public <T> Configer<T> obtain(ConfigDescriptor<T> descriptor){
        return new Configer<T>(
                configers.get(descriptor).isActive(),
                descriptor,
                configers.get(descriptor).getValue()
        );
    }

}
