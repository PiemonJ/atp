package com.bytedance.atp.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Rule {
    /**
     * 测试覆盖率
     */
    COVERAGE(0, Category.CODE),

    /**
     * 窗口期回滚
     */
    WINDOW_PERIOD_ROLLS_BACK(21, Category.RELEASE),

    /**
     * 窗口期发布
     *
     */
    WINDOW_PERIOD_RELEASE(22, Category.RELEASE);


    public int code;

    public Category category;


}
