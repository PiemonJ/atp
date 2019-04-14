package com.bytedance.atp;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ConfigEnv {

    TEST(0,"测试"),
    UAT(1,"预发"),
    PRD(2,"生产");

    public int code;

    public String evnDesc;
}
