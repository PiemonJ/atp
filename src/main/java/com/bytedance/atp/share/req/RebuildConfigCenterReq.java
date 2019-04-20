package com.bytedance.atp.share.req;

import com.bytedance.atp.common.ConfigScalar;
import com.bytedance.atp.common.Env;
import lombok.Data;

import java.util.Map;

@Data
public class RebuildConfigCenterReq {

    long ccId;

    Env env;

    Map<ConfigScalar,String> configer;
}
