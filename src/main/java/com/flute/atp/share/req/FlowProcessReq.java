package com.flute.atp.share.req;

import com.flute.atp.common.Category;
import com.flute.atp.common.Direction;
import com.flute.atp.common.Env;
import com.flute.atp.common.ExeStrategy;
import lombok.Data;

@Data
public class FlowProcessReq {

    Env env;

    String gitlab;

    Category category;

    Direction direction;

    ExeStrategy exeStrategy;



}
