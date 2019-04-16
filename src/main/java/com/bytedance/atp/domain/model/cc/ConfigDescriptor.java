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
@Data
@Builder
public class ConfigDescriptor<T> {


    public static final ConfigDescriptor<Single<String>> PROJECT_LOCATION =
            ConfigDescriptor.<Single<String>>builder()
                    .type(new TypeReference<Single<String>>(){}.getType())
                    .scalar(ConfigScalar.PROJECT_LOCATION)
                    .categories(Arrays.asList(Category.values()))
                    .referenceRules(Arrays.asList(Rule.values()))
                    .build();


    public static final ConfigDescriptor<List<Weekday>> RELEASE_VALID_DAY =
            ConfigDescriptor.<List<Weekday>>builder()
                    .type(new TypeReference<List<Weekday>>(){}.getType())
                    .scalar(ConfigScalar.RELEASE_VALID_DAY)
                    .categories(Arrays.asList(Category.RELEASE))
                    .referenceRules(Arrays.asList(Rule.WINDOW_PERIOD_RELEASE))
                    .build();


    public static final ConfigDescriptor<Single<BigDecimal>> CODE_COVERAGE =
            ConfigDescriptor.<Single<BigDecimal>>builder()
                    .type(new TypeReference<Single<BigDecimal>>(){}.getType())
                    .scalar(ConfigScalar.CODE_COVERAGE)
                    .categories(Arrays.asList(Category.CODE))
                    .referenceRules(Arrays.asList(Rule.COVERAGE))
                    .build();


    Type type;

    ConfigScalar scalar;

    List<Category> categories;

    List<Rule> referenceRules;



}
