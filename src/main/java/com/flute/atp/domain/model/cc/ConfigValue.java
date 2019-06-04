package com.flute.atp.domain.model.cc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConfigValue {

    public String json;

    public static ConfigValue apply(String json){
        return new ConfigValue(json);
    }
}
