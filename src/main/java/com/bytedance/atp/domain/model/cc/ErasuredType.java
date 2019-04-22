package com.bytedance.atp.domain.model.cc;

import com.alibaba.fastjson.TypeReference;
import com.bytedance.atp.common.DateInterval;
import com.bytedance.atp.common.Single;
import com.bytedance.atp.common.Weekday;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.List;

@Getter
@AllArgsConstructor
public enum ErasuredType {

    SINGLE_STRING(1,new TypeReference<Single<String>>(){}.getType()),
    SINGLE_BIGDECIMAL(2,new TypeReference<Single<BigDecimal>>(){}.getType()),
    LIST_WEEKDAY(3,new TypeReference<List<Weekday>>(){}.getType()),
    SINGLE_DATEINTERVAL(4,new TypeReference<Single<DateInterval>>(){}.getType());

    public int code;

    public Type type;
}
