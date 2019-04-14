package com.bytedance.atp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConfigValue {

    public List<String> values;

    public static ConfigValue apply(String ... value){

        return new ConfigValue(Arrays.asList(value));
    }
}
