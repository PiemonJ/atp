package com.bytedance.atp;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.bytedance.atp.domain.model.common.Category;
import com.bytedance.atp.domain.model.common.Single;
import com.bytedance.atp.domain.model.common.Weekday;
import com.bytedance.atp.domain.model.group.Rule;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 一个配置项
 * 例如validReleaseDays(有效发布日)
 */
@Getter
@AllArgsConstructor
public enum ConfigItem {

    /**
     * Common 公共参数
     */
    //工程地址
    PROJECT_LOCATION(
            10,
            "项目工程地址",
            Arrays.asList(Category.values()),
            new TypeReference<Single<String>>(){}.getType(),
            Arrays.asList(Rule.values())
    ){
        public Optional<String> convertTo(ConfigValue value){
            List<String> values = value.getValues();
            if (null == values || values.size() == 0){
                return Optional.<String>empty();
            } else {
                return Optional.<String>of(values.get(0));
            }
        }
    },

    /**
     * 发布相关参数
     */

    //发布有效期
    RELEASE_VALID_DAY(
            100,
            "发版合法日",
            Arrays.asList(Category.RELEASE),
            new TypeReference<List<Weekday>>(){}.getType(),
            Arrays.asList(Rule.WINDOW_PERIOD_RELEASE)
    ){
        public Optional<List<Weekday>> convertTo(ConfigValue value){
            List<String> values = value.getValues();
            if (null == values || values.size() == 0){
                return Optional.<List<Weekday>>empty();
            } else {
                List<Weekday> weekdays = values.stream()
                        .map(week -> Weekday.valueOf(week))
                        .collect(Collectors.toList());
                return Optional.<List<Weekday>>of(weekdays);
            }
        }
    },


    /**
     * 代码相关
     *
     */
    //Code覆盖率
    CODE_COVERAGE(
            1000,
            "代码覆盖率",
            Arrays.asList(Category.CODE),
            new TypeReference<Single<BigDecimal>>(){}.getType(),
            Arrays.asList(Rule.COVERAGE)
    ){

        public Optional<BigDecimal> convertTo(ConfigValue value){
            List<String> values = value.getValues();
            if (null == values || values.size() == 0){
                return Optional.<BigDecimal>empty();
            } else {
                return Optional.<BigDecimal>of(new BigDecimal(values.get(0)));
            }
        }
    };



    public int code;

    public String puttyDesc;

    List<Category> categories;

    Type type;

    List<Rule> referenceRules;


    public abstract <T> Optional<T> convertTo(ConfigValue value);

}
