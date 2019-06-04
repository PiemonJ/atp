package com.flute.atp.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Weekday {

    MON(1,"周一"),
    TUE(2,"周二"),
    WED(3,"周三"),
    THU(4,"周四"),
    FRI(5,"周五"),
    SAT(6,"周六"),
    SUN(7,"周日");

    public int code;

    public String desc;
}
