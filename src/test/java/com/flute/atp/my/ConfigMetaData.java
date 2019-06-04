package com.flute.atp.my;

import java.io.Serializable;

public interface ConfigMetaData<T extends Serializable> extends Serializable {


    Class<T> getType();

    String getName();
}
