package com.flute.atp.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Single<T> {

    public T value;

    public static <T> Single<T> of(T value){
        return new Single<T>(value);
    }
}
