package com.bytedance.atp.domain.model.cc;

public class BuildInfo extends Info<BuildInfo> {


    @Override
    protected boolean equalsCore(BuildInfo other) {
        return false;
    }

    @Override
    protected int getHashCodeCore() {
        return 0;
    }
}
