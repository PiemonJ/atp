package com.bytedance.atp.domain.model.cc;

import com.alibaba.fastjson.TypeReference;
import com.bytedance.atp.domain.model.common.Category;
import com.bytedance.atp.domain.model.common.Single;
import com.bytedance.atp.domain.model.common.Weekday;
import com.bytedance.atp.domain.model.group.Rule;
import lombok.Builder;
import lombok.Data;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Data
@Builder
public class ConfigDescriptor<T> {

    public static ConcurrentHashMap<ConfigScalar,ConfigDescriptor> dic = new ConcurrentHashMap<ConfigScalar,ConfigDescriptor>() {
        {
            this.put(ConfigScalar.PROJECT_LOCATION, PROJECT_LOCATION);
            this.put(ConfigScalar.RELEASE_VALID_DAY, RELEASE_VALID_DAY);
            this.put(ConfigScalar.CODE_COVERAGE,CODE_COVERAGE);
        }
    };


    public static final ConfigDescriptor<Single<String>> PROJECT_LOCATION =
            ConfigDescriptor.<Single<String>>builder()
                    .type(ErasuredType.SINGLE_STRING)
                    .scalar(ConfigScalar.PROJECT_LOCATION)
                    .categories(Arrays.asList(Category.values()))
                    .referenceRules(Arrays.asList(Rule.values()))
                    .build();


    public static final ConfigDescriptor<List<Weekday>> RELEASE_VALID_DAY =
            ConfigDescriptor.<List<Weekday>>builder()
                    .type(ErasuredType.LIST_WEEKDAY)
                    .scalar(ConfigScalar.RELEASE_VALID_DAY)
                    .categories(Arrays.asList(Category.RELEASE))
                    .referenceRules(Arrays.asList(Rule.WINDOW_PERIOD_RELEASE))
                    .build();


    public static final ConfigDescriptor<Single<BigDecimal>> CODE_COVERAGE =
            ConfigDescriptor.<Single<BigDecimal>>builder()
                    .type(ErasuredType.SINGLE_BIGDECIMAL)
                    .scalar(ConfigScalar.CODE_COVERAGE)
                    .categories(Arrays.asList(Category.CODE))
                    .referenceRules(Arrays.asList(Rule.COVERAGE))
                    .build();


    ErasuredType type;

    ConfigScalar scalar;

    List<Category> categories;

    List<Rule> referenceRules;


    public static ConfigDescriptor apply(ConfigScalar scalar){
        return dic.get(scalar);
    }

}
