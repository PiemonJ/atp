package com.bytedance.atp;

import com.bytedance.atp.domain.model.common.Category;
import com.bytedance.atp.domain.model.common.Tuple2;
import com.bytedance.atp.domain.model.group.Rule;
import io.reactivex.Flowable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 配置中心
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConfigCenter {

    String ruleGroupId;

    List<ConfigTable> configTables = new ArrayList<>();


    public void configApply(ConfigEnv env,List<Configer> configers){

        ConfigTable configTable = Flowable.fromArray(Category.values())
                .map(
                        category -> {
                            List<Configer> collect = configers.stream()
                                    .filter(configer -> configer.item.categories.contains(category))
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


    public ConfigPile obtainConfigPile(Rule rule,ConfigEnv env){


        List<Configer> configers = new ArrayList<>();

        Optional<ConfigTable> table = this.getConfigTables()
                .stream()
                .filter(configTable -> configTable.env == env)
                .findAny();
        if (table.isPresent()){
            Optional<ConfigBlock> block = table.get()
                    .getBlocks()
                    .stream()
                    .filter(configBlock -> configBlock.category == rule.category)
                    .findAny();

            if (block.isPresent()){
                configers = block.get()
                        .getConfigers()
                        .stream()
                        .filter(configer -> configer.item.referenceRules.contains(rule))
                        .collect(Collectors.toList());

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
