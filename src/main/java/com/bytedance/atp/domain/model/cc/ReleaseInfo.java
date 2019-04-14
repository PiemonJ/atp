package com.bytedance.atp.domain.model.cc;

import com.bytedance.atp.domain.model.common.Weekday;
import lombok.Data;

import java.util.List;
@Data
public class ReleaseInfo extends Info<ReleaseInfo> {


    List<Weekday> validReleaseDay;

    @Override
    protected boolean equalsCore(ReleaseInfo other) {
        return false;
    }

    @Override
    protected int getHashCodeCore() {
        return 0;
    }
}
