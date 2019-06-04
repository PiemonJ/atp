package com.flute.atp.common;

public final class TypeSafeKeys {

//    static enum StringKeys implements MetaDataKey<String>
//    {
//        A1("key1");
//
//        private final String value;
//
//        StringKeys(String value) { this.value = value; }
//
//        @Override
//        public String getValue() { return value; }
//    }
//
//    static enum IntegerKeys implements MetaDataKey<Integer>
//    {
//        A2(0);
//
//        private final Integer value;
//
//        IntegerKeys (Integer value) { this.value = value; }
//
//        @Override
//        public Integer getValue() { return value; }
//    }
//
//    public static final MetaDataKey<String> A1 = StringKeys.A1;
//    public static final MetaDataKey<Integer> A2 = IntegerKeys.A2;







    public static final MetaDataKey<String> A1 =
            new BasicMetaDataKey<String>("value") {};
    public static final MetaDataKey<Integer> A2 =
            new BasicMetaDataKey<Integer>(0) {};
}
