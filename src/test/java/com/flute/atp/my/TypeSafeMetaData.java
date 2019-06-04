package com.flute.atp.my;

import com.alibaba.fastjson.TypeReference;
import com.flute.atp.common.Single;

public final class TypeSafeMetaData {


    public enum StringSingleMetaData implements SingleConfigMetaData<String> {
        ;

        @Override
        public Class<Single<String>> getType() {
            Single<String> single = new Single<>();

            Class<? extends TypeReference<Single<String>>> aClass = new TypeReference<Single<String>>() {
            }.getClass();


            return null;
        }

        @Override
        public String getName() {
            return null;
        }
    }
}
