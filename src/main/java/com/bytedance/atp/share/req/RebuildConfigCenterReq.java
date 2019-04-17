package com.bytedance.atp.share.req;

import com.bytedance.atp.domain.model.cc.ConfigScalar;
import com.bytedance.atp.domain.model.cc.Env;
import lombok.Data;

import java.util.Map;

@Data
public class RebuildConfigCenterReq {

    long ccId;

    Env env;

    Map<ConfigScalar,String> configer;
}
