package com.bytedance.atp.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 配置的标量
 *
 *
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ConfigScalar {

    PROJECT_LOCATION(0,"项目工程地址"),



    RELEASE_VALID_DAY(100,"发版合法日"),

    CODE_COVERAGE(1000,"代码覆盖率"),
    CODE_OK_RATE(1001,"测试成功率");

    int code;

    String desc;

}
