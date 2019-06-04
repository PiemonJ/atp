package com.flute.atp.common;

import java.io.Serializable;

public interface MetaDataKey<T extends Serializable> extends Serializable
{
    T getValue();
}