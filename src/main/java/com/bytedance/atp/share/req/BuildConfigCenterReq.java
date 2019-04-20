package com.bytedance.atp.share.req;

import com.bytedance.atp.common.ConfigScalar;
import com.bytedance.atp.common.Env;
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
