package com.bytedance.atp.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
@AllArgsConstructor
public enum Rule {
    /**
     * 测试覆盖率
     */
    COVERAGE(0, Category.CODE, Arrays.asList(ConfigScalar.CODE_COVERAGE)),

    /**
     * 测试成功率
     */
    OK_RATE(1, Category.CODE,Arrays.asList(ConfigScalar.CODE_OK_RATE)),

    /**
     * 分支名规范化
     */
    BRANCH_NAME_STANDARD(11, Category.BUILD,Arrays.asList()),

    /**
     * 窗口期发布
     *
     */
    WINDOW_PERIOD_RELEASE(22, Category.RELEASE,Arrays.asList(ConfigScalar.RELEASE_VALID_DAY));


    public int code;

    public Category category;

    public List<ConfigScalar> configScalars;


}
