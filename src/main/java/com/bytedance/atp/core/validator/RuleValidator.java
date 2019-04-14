package com.bytedance.atp.core.validator;

import com.bytedance.atp.domain.model.cc.Info;
import com.bytedance.atp.domain.model.common.Tuple2;

import java.util.List;

public interface RuleValidator<T> {

    public List<Tuple2<String,Boolean>> argsValidate(Info info);

    public Tuple2<Object,Boolean> ruleValidate(Info info);

}
