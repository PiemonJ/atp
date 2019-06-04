package com.flute.atp.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 验证报告
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class VerificationReport {

    public Rule rule;

    public String expect;

    public String actual;

    public String display;

    public boolean ok;

    public boolean ok(){
        return ok;
    }


}
