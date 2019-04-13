package com.bytedance.atp.domain.model.runtime;

/**
 * 执行策略
 */
public enum ExeStrategy {

    //快速失败
    FAIL_FAST,
    //忽略失败
    THROUGHOUT;
}
