package com.bytedance.atp.domain.model.cc;

public class ReleaseInfo extends Info<ReleaseInfo> {

    @Override
    protected boolean equalsCore(ReleaseInfo other) {
        return false;
    }

    @Override
    protected int getHashCodeCore() {
        return 0;
    }
}
