package com.bytedance.atp.common;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Env {

    TEST(0,"测试"),
    UAT(1,"预发"),
    PRD(2,"生产");

    public int code;

    public String evnDesc;
}
