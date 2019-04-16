package com.bytedance.atp.core.validator;

import com.bytedance.atp.domain.model.cc.ConfigPile;
import com.bytedance.atp.domain.model.common.Tuple2;

import java.util.List;

public interface RuleValidator {

    public List<Tuple2<String,Boolean>> argsValidate(ConfigPile pile);

    public Tuple2<Object,Boolean> ruleValidate(ConfigPile pile);

}
