package com.bytedance.atp.domain.model.cc;

import com.bytedance.atp.domain.model.group.Rule;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 针对某个规则，输出的该规则会用到的执行器运行时参数
 *
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConfigPile {

    public long ruleGroupId;

    public Env env;

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
        return new Configer<>(
                descriptor,
                configers.get(descriptor).getValue()
        );
    }

}
