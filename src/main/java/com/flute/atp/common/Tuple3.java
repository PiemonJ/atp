package com.flute.atp.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Tuple3<K,V,T> {

    public K _1;

    public V _2;

    public T _3;

    public static <K,V,T> Tuple3<K,V,T> apply(K _1,V _2,T _3){
        return new Tuple3<K,V,T>(_1,_2,_3);
    }

    public static <K,V,T> Tuple3<K,V,T> apply(Tuple2<K,V> tuple2,T _3){
        return new Tuple3<K,V,T>(tuple2._1,tuple2._2,_3);
    }


    public T ok(){
        return _3;
    }
}