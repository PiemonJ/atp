package com.bytedance.atp.domain.model.group;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Rule {
    /**
     * 测试覆盖率
     */
    COVERAGE(0,RuleCategory.CODE),

    /**
     * 窗口期回滚
     */
    WINDOW_PERIOD_ROLLS_BACK(21,RuleCategory.RELEASE),

    /**
     * 窗口期发布
     *
     */
    WINDOW_PERIOD_RELEASE(22,RuleCategory.RELEASE);


    public int code;

    public RuleCategory category;


}
