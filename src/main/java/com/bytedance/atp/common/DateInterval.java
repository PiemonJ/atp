package com.bytedance.atp.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DateInterval {

    Date from;

    Date to;


    public boolean within(Date date){

        return date.after(from) && date.before(to);

    }
}
