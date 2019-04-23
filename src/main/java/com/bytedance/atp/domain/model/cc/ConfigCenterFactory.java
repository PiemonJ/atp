package com.bytedance.atp.domain.model.cc;

import com.bytedance.atp.common.ConfigScalar;
import com.bytedance.atp.common.Env;
import com.bytedance.atp.common.Rule;

import java.util.*;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConfigCenterFactory {


    public static ConfigCenter configCenterIniter(String gitlab,String ruleGroupId, List<Rule> rules){

        Set<ConfigDescriptor> validDescriptors = rules.parallelStream()
                .flatMap(rule -> ConfigDescriptor.descriptors.stream()
                        .filter(descriptor -> descriptor.getReferenceRules().contains(rule)))
                .collect(Collectors.toSet());


        Stream<Configer> configerStream = validDescriptors.parallelStream()
                .map(descriptor -> Configer.apply(descriptor, new ConfigValue(descriptor.defaultValue), true));

        List<Configer> configers = configerStream.collect(Collectors.toList());


        ConfigCenter cc = new ConfigCenter();

        cc.setId(UUID.randomUUID().toString());

        cc.setVersion(0);

        cc.setGitlab(gitlab);

        cc.setRuleGroupId(ruleGroupId);

        cc.configApply(configers);

        return cc;


    }


    public static Function<Map<ConfigScalar,String>,List<Configer>> mapping = map -> map.entrySet().stream()
            .map(entry -> Configer.apply(entry.getKey(), entry.getValue()))
            .collect(Collectors.toList());

    public static ConfigCenter configCenterDefiner(ConfigCenter cc, Map<ConfigScalar,String> defined){


        List<Configer> definedConfigers = mapping.apply(defined);

        List<Configer> allConfigers = cc.obtainAllConfiger();

        List<Configer> activeConfigers = cc.obtainAllActiveConfiger();

        ConcurrentMap<ConfigScalar, Configer> activeMap = activeConfigers.parallelStream()
                .collect(Collectors.toConcurrentMap(configer -> configer.getDescriptor().getScalar(), configer -> configer));

        definedConfigers.stream()
                .forEach(
                        definedConfiger ->
                            activeMap.put(definedConfiger.getDescriptor().getScalar(),definedConfiger)

                );

        List<Configer> mixedActiveConfigers = new ArrayList<>(activeMap.values());

        cc.configApply(mixin(allConfigers,mixedActiveConfigers));

        return cc;

    }


    public static ConfigCenter configCenterChanger(String gitlab,ConfigCenter cc, List<Rule> rules){

        List<Configer> allConfigers = cc.obtainAllConfiger();

        Set<ConfigDescriptor> activeDescriptors = rules.parallelStream()
                .flatMap(rule -> ConfigDescriptor.descriptors.stream()
                        .filter(descriptor -> descriptor.getReferenceRules().contains(rule)))
                .collect(Collectors.toSet());

        Stream<Configer> configerStream = activeDescriptors.parallelStream()
                .map(descriptor -> Configer.apply(descriptor, new ConfigValue(descriptor.defaultValue), true));

        List<Configer> activeConfigers = configerStream.collect(Collectors.toList());


        cc.configApply(mixin(allConfigers,activeConfigers));

        cc.setGitlab(gitlab);

        return cc;

    }

    private static List<Configer> mixin(List<Configer> historyConfigers, List<Configer> activeConfigers) {


        ConcurrentMap<ConfigScalar, Configer> all = historyConfigers.parallelStream()
                .map(configer -> configer.deactive())
                .collect(Collectors.toConcurrentMap(configer -> configer.getDescriptor().getScalar(), configer -> configer));


        activeConfigers.stream()
                .forEach(configer -> {
                    Configer exist = all.get(configer.getDescriptor().getScalar());
                    if (exist == null){
                        all.put(configer.getDescriptor().getScalar(),configer);
                    } else {
                        exist.active();
                    }
                }
            );

        return new ArrayList<>(all.values());

    }
}
