package com.flute.atp.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Timer {

    public Weekday weekday;

    public int from;

    public int to;

    public static final Timer TUE_VALID = new Timer(Weekday.TUE,20,24);

    public static final Timer THU_VALID = new Timer(Weekday.THU,20,24);

    public static String putty(Timer t1,Timer t2){
        return t1.getWeekday().getDesc() + "[" + t1.getFrom() + "~" + t1.getTo() + "]"
                + "-----"
                + t2.getWeekday().getDesc() + "[" + t2.getFrom() + "~" + t2.getTo() + "]";
    }

}
