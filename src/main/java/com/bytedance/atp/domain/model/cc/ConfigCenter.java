package com.bytedance.atp.domain.model.cc;

import com.bytedance.atp.domain.model.AggregateRoot;
import com.bytedance.atp.common.Tuple2;
import com.bytedance.atp.common.Category;
import com.bytedance.atp.common.ConfigScalar;
import com.bytedance.atp.common.Env;
import com.bytedance.atp.common.Rule;
import io.reactivex.Flowable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 配置中心
 */
@Data
@Builder
@Document
@NoArgsConstructor
@AllArgsConstructor
public class ConfigCenter extends AggregateRoot {

    String ruleGroupId;

//    Env env;

    List<ConfigTable> configTables = new ArrayList<>();


    public static Function<Map<ConfigScalar,String>,List<Configer>> mapping = map -> map.entrySet().stream()
                .map(entry -> Configer.apply(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());




    public void configApply(Env env, Map<ConfigScalar,String> configers){

        List<Configer> cs = ConfigCenter.mapping.apply(configers);

        configApply(env,cs);
    }


    public void configApply(Env env, List<Configer> configers){

        ConfigTable configTable = Flowable.fromArray(Category.values())
                .map(
                        category -> {
                            List<Configer> collect = configers.stream()
                                    .filter(configer -> configer.getDescriptor().categories.contains(category))
                                    .collect(Collectors.toList());
                            return Tuple2.apply(category, collect);

                        }
                ).map(
                        tuple2 -> {
                            Category category = tuple2._1;
                            List<Configer> confs = tuple2._2;
                            return ConfigBlock.builder()
                                    .category(category)
                                    .configers(confs)
                                    .build();
                        }
                ).reduce(
                        ConfigTable.builder()
                                .env(env)
                                .blocks(new ArrayList<ConfigBlock>())
                                .build(),
                        (table, block) -> {
                            table.getBlocks().add(block);
                            return table;
                        }
                ).blockingGet();


        List<ConfigTable> tables = configTables.stream()
                .filter(ct -> configTable.env != env)
                .collect(Collectors.toList());
        tables.add(configTable);
        this.configTables = tables;

    }



    public ConfigPile obtainConfigPile(Rule rule, Env env){


        ConcurrentMap<ConfigDescriptor, Configer> configers = new ConcurrentHashMap<ConfigDescriptor,Configer>();

        Optional<ConfigTable> table = this.getConfigTables()
                .stream()
                .filter(configTable -> configTable.env == env)
                .findAny();
        if (table.isPresent()){
            Optional<ConfigBlock> block = table.get()
                    .getBlocks()
                    .stream()
                    .filter(configBlock -> configBlock.category == rule.getCategory())
                    .findAny();

            if (block.isPresent()){
                configers = block.get()
                        .getConfigers()
                        .stream()
                        .filter(configer -> configer.getDescriptor().referenceRules.contains(rule))
                        .collect(
                                Collectors.toConcurrentMap(
                                        x -> x.getDescriptor(),
                                        x -> x
                                )
                        );


            }
        }

        return ConfigPile.builder()
                .env(env)
                .rule(rule)
                .ruleGroupId(ruleGroupId)
                .configers(configers)
                .build();

    }

}
