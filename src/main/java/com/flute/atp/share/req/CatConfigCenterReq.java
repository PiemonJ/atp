package com.flute.atp.share.req;

import com.flute.atp.common.Env;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CatConfigCenterReq {

    public Env env;

    public String gitlab;

    public String ruleGroupId;




}
