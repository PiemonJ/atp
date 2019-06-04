package com.flute.atp.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.function.Function;

@Getter
@AllArgsConstructor
public class Tuple2<K,V> {

    public K _1;

    public V _2;

    public static <K,V> Function<V,Tuple2<K,V>> currying(K k){

        return new Function<V, Tuple2<K, V>>() {
            @Override
            public Tuple2<K, V> apply(V v) {
                return Tuple2.apply(k,v);
            }
        };

    }

    public static <K,V> Tuple2<K,V> apply(K _1,V _2){
        return new Tuple2<K,V>(_1,_2);
    }

    public V ok(){
        return _2;
    }
}
