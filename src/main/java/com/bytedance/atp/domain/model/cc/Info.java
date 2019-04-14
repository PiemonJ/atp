package com.bytedance.atp.domain.model.cc;

import com.bytedance.atp.domain.model.ValueObject;
import com.bytedance.atp.domain.model.group.RuleCategory;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class Info<T> extends ValueObject<T> {

    //公共信息
    RuleCategory category;

}
