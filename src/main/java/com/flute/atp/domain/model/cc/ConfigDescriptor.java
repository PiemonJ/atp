package com.flute.atp.domain.model.cc;

import com.alibaba.fastjson.JSON;
import com.bytedance.atp.common.*;
import com.flute.atp.common.*;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Data
@Builder
public class ConfigDescriptor<T> {






//    public static final ConfigDescriptor<Single<String>> PROJECT_LOCATION =
//            ConfigDescriptor.<Single<String>>builder()
//                    .type(ErasuredType.SINGLE_STRING)
//                    .scalar(ConfigScalar.PROJECT_LOCATION)
//                    .categories(Arrays.asList(Category.values()))
//                    .referenceRules(Arrays.asList(Rule.values()))
//                    .defaultValue("")
//                    .build();


    public static final ConfigDescriptor<Single<Tuple2<Timer,Timer>>> RELEASE_VALID_DAY =
            ConfigDescriptor.<Single<Tuple2<Timer,Timer>>>builder()
                    .type(ErasuredType.SINGLE_TUPLE_TIMER)
                    .scalar(ConfigScalar.RELEASE_VALID_DAY)
                    .categories(Arrays.asList(Category.RELEASE))
                    .referenceRules(Arrays.asList(Rule.WINDOW_PERIOD_RELEASE))
                    .defaultValue(JSON.toJSONString(Single.of(Tuple2.<Timer,Timer>apply(Timer.TUE_VALID,Timer.TUE_VALID))))
                    .build();


    public static final ConfigDescriptor<Single<BigDecimal>> CODE_COVERAGE =
            ConfigDescriptor.<Single<BigDecimal>>builder()
                    .type(ErasuredType.SINGLE_BIGDECIMAL)
                    .scalar(ConfigScalar.CODE_COVERAGE)
                    .categories(Arrays.asList(Category.CODE))
                    .referenceRules(Arrays.asList(Rule.COVERAGE))
                    .defaultValue(JSON.toJSONString(Single.of(BigDecimal.valueOf(0.8D))))
                    .build();


    public static final ConfigDescriptor<Single<BigDecimal>> CODE_OK_RATE =
            ConfigDescriptor.<Single<BigDecimal>>builder()
                    .type(ErasuredType.SINGLE_BIGDECIMAL)
                    .scalar(ConfigScalar.CODE_OK_RATE)
                    .categories(Arrays.asList(Category.CODE))
                    .referenceRules(Arrays.asList(Rule.OK_RATE))
                    .defaultValue(JSON.toJSONString(Single.of(BigDecimal.valueOf(0.8D))))
                    .build();


    public static ConcurrentHashMap<ConfigScalar,ConfigDescriptor> dic = new ConcurrentHashMap<ConfigScalar,ConfigDescriptor>() {
        {
            this.put(ConfigScalar.RELEASE_VALID_DAY, RELEASE_VALID_DAY);
            this.put(ConfigScalar.CODE_COVERAGE,CODE_COVERAGE);
            this.put(ConfigScalar.CODE_OK_RATE,CODE_OK_RATE);
        }
    };


    public static final List<ConfigDescriptor<?>> descriptors = Arrays.asList(
            RELEASE_VALID_DAY,
            CODE_COVERAGE,
            CODE_OK_RATE);

    ErasuredType type;

    ConfigScalar scalar;

    List<Category> categories;

    List<Rule> referenceRules;

    String defaultValue;


    public static ConfigDescriptor apply(ConfigScalar scalar){
        return dic.get(scalar);
    }

}
