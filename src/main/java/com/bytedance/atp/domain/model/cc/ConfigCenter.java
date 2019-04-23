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

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    String gitlab;

    ConfigTable configTable;




    public void configApply(List<Configer> configers){

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
                                .blocks(new ArrayList<ConfigBlock>())
                                .build(),
                        (table, block) -> {
                            table.getBlocks().add(block);
                            return table;
                        }
                ).blockingGet();



        this.configTable = configTable;

    }



    public ConfigPile obtainConfigPile(Rule rule){


        ConcurrentMap<ConfigDescriptor, Configer> configers = new ConcurrentHashMap<ConfigDescriptor,Configer>();

        ConfigTable configTable = getConfigTable();
        if (configTable != null){
            Optional<ConfigBlock> block = configTable
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
                .gitlab(gitlab)
                .rule(rule)
                .ruleGroupId(ruleGroupId)
                .configers(configers)
                .build();

    }


    public List<Configer> obtainAllConfiger(){

        return configTable.getBlocks().parallelStream()
                .flatMap(block -> block.getConfigers().stream())
                .collect(Collectors.toList());
    }

    public List<Configer> obtainAllActiveConfiger(){

        return configTable.getBlocks().parallelStream()
                .flatMap(block -> block.getConfigers().stream())
                .filter(configer -> configer.isActive())
                .collect(Collectors.toList());
    }
}
