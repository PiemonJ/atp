package com.flute.atp.core.validator;

import com.flute.atp.common.Rule;
import com.flute.atp.common.VerificationReport;
import com.flute.atp.domain.model.cc.ConfigPile;
import com.flute.atp.common.Tuple2;

import java.util.List;

public interface RuleValidator<T extends Rule> {

    public List<Tuple2<String,Boolean>> argsValidate(ConfigPile pile);

    public VerificationReport ruleValidate(ConfigPile pile);

}
