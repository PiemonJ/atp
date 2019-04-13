package com.bytedance.atp.domain.model.cc;

public class CodeInfo extends Info<CodeInfo> {

    @Override
    protected boolean equalsCore(CodeInfo other) {
        return false;
    }

    @Override
    protected int getHashCodeCore() {
        return 0;
    }
}
