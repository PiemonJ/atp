package com.flute.atp.share.req;

import com.flute.atp.common.ConfigScalar;
import com.flute.atp.common.Env;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BuildConfigCenterReq {

    Env env;

    String ruleGroupId;

    Map<ConfigScalar,String> configer;

}
