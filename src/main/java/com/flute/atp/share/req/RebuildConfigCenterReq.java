package com.flute.atp.share.req;

import com.flute.atp.common.ConfigScalar;
import com.flute.atp.common.Env;
import lombok.Data;

import java.util.Map;

@Data
public class RebuildConfigCenterReq {

    long ccId;

    Env env;

    Map<ConfigScalar,String> configer;
}
