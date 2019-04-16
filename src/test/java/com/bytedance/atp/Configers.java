package com.bytedance.atp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Optional;

/**
 * 配置
 *
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Configers<T> {

    ConfigItem item;

    ConfigValue value;

    T demo;

    public <T> Optional<T> obtainValue(){
        return item.convertTo(value);
    }


}
