package com.bytedance.atp.core.validator;

import com.bytedance.atp.domain.model.cc.Info;
import com.bytedance.atp.domain.model.common.Tuple2;

@FunctionalInterface
public interface RuleValidator {

    public Tuple2<Object,Boolean> validate(Info info);

}
