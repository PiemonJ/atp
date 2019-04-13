package com.bytedance.atp.domain.model.cc;

import com.bytedance.atp.domain.model.ValueObject;
import com.bytedance.atp.domain.model.group.RuleCategory;

public abstract class Info<T> extends ValueObject<T> {

    //公共信息
    RuleCategory category;

}
