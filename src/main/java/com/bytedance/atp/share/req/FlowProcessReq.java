package com.bytedance.atp.share.req;

import com.bytedance.atp.domain.model.cc.Env;
import com.bytedance.atp.domain.model.common.Direction;
import com.bytedance.atp.domain.model.runtime.ExeStrategy;
import lombok.Data;

@Data
public class FlowProcessReq {

    Env env;

    ExeStrategy exeStrategy;

    String ruleGroupId;

    String flowId;

    Direction direction;

}
