package com.bytedance.atp.domain.model.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Tuple2<K,V> {

    public K _1;

    public V _2;

    public static <K,V> Tuple2<K,V> apply(K _1,V _2){
        return new Tuple2<K,V>(_1,_2);
    }

    public V ok(){
        return _2;
    }
}
