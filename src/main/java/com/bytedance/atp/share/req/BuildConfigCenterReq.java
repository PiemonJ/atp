package com.bytedance.atp.share.req;

import com.bytedance.atp.domain.model.cc.ConfigScalar;
import com.bytedance.atp.domain.model.cc.Env;
import lombok.Data;

import java.util.Map;

@Data
public class BuildConfigCenterReq {

    Env env;

    String ruleGroupId;

    Map<ConfigScalar,String> configer;

}
