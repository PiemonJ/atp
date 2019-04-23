package com.bytedance.atp.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Timer {

    public Weekday weekday;

    public int from;

    public int to;

    public static final Timer TUE_VALID = new Timer(Weekday.TUE,20,24);

    public static final Timer THU_VALID = new Timer(Weekday.THU,20,24);

}
