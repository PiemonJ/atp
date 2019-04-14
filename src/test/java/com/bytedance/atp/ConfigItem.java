package com.bytedance.atp;

import com.alibaba.fastjson.TypeReference;
import com.bytedance.atp.domain.model.common.Category;
import com.bytedance.atp.domain.model.common.Weekday;
import com.bytedance.atp.domain.model.group.Rule;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

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
            new TypeReference<String>(){}.getType(),
            Arrays.asList(Rule.values())
    ),

    /**
     * 发布相关参数
     */

    //发布有效期
    RELEASE_VALID_DAY(
            100,
            "发版合法日",
            Arrays.asList(Category.RELEASE),
            new TypeReference<List<Weekday>>(){}.getType(),
            Arrays.asList(Rule.WINDOW_PERIOD_RELEASE)),


    /**
     * 代码相关
     *
     */
    //Code覆盖率
    CODE_COVERAGE(
            1000,
            "代码覆盖率",
            Arrays.asList(Category.CODE),
            new TypeReference<BigDecimal>(){}.getType(),
            Arrays.asList(Rule.COVERAGE));

    public int code;

    public String puttyDesc;

    List<Category> categories;

    Type type;

    List<Rule> referenceRules;



}
