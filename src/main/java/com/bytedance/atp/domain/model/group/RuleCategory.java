package com.bytedance.atp.domain.model.group;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 规则类目
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum RuleCategory {

    CODE(0,""),
    BUILD(1,""),
    RELEASE(2,"");


    public int code;

    public String description;
}
