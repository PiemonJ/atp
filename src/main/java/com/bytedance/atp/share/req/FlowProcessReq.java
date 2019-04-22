package com.bytedance.atp.share.req;

import com.bytedance.atp.common.Category;
import com.bytedance.atp.common.Direction;
import com.bytedance.atp.common.Env;
import com.bytedance.atp.common.ExeStrategy;
import lombok.Data;

@Data
public class FlowProcessReq {

    Env env;

    String gitlab;

    Category category;

    Direction direction;

    ExeStrategy exeStrategy;



}
