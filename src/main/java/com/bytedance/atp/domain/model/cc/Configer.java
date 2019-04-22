package com.bytedance.atp.domain.model.cc;

import com.alibaba.fastjson.JSON;
import com.bytedance.atp.common.ConfigScalar;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Setter
@Getter
@Builder
@AllArgsConstructor
public class Configer<T> {

    private boolean active;

    private ConfigDescriptor<T> descriptor;

    private ConfigValue value;

    public static <T> Configer<T> apply(ConfigDescriptor<T> descriptor,ConfigValue value,boolean active){
        return new Configer<T>(active,descriptor,value);
    }

    public static Configer apply(ConfigScalar scalar, String json){
        ConfigDescriptor descriptor = ConfigDescriptor.apply(scalar);
        ConfigValue value = ConfigValue.apply(json);
        return Configer.apply(descriptor,value,true);
    }


    public Optional<T> obtainValue(){

        if (StringUtils.isEmpty(value.json))
            return Optional.<T>empty();
        else
            return Optional.ofNullable(JSON.<T>parseObject(value.json, descriptor.type.type));

    }

    public Configer deactive(){
        this.active = false;
        return this;
    }

    public Configer active(){
        this.active = true;
        return this;
    }


}
