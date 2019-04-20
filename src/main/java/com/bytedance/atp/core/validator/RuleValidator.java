package com.bytedance.atp.core.validator;

import com.bytedance.atp.common.Rule;
import com.bytedance.atp.domain.model.cc.ConfigPile;
import com.bytedance.atp.common.Tuple2;

import java.util.List;

public interface RuleValidator<T extends Rule> {

    public List<Tuple2<String,Boolean>> argsValidate(ConfigPile pile);

    public Tuple2<T,Boolean> ruleValidate(ConfigPile pile);

}
