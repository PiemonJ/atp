package com.flute.atp.common;

import java.io.Serializable;

public abstract class BasicMetaDataKey<T extends Serializable>
        implements MetaDataKey<T>
{
    private final T value;

    public BasicMetaDataKey(T value)
    {
        this.value = value;
    }

    @Override
    public T getValue()
    {
        return value;
    }

    // @Override equals
    // @Override hashCode
}