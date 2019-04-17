package com.bytedance.atp.domain.model.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Direction {

    TORUN(com.bytedance.atp.domain.model.runtime.State.READY,com.bytedance.atp.domain.model.runtime.State.RUNNING),
    INTERRUPT(com.bytedance.atp.domain.model.runtime.State.RUNNING,com.bytedance.atp.domain.model.runtime.State.INTERRUPT),
    PAUSE(com.bytedance.atp.domain.model.runtime.State.RUNNING,com.bytedance.atp.domain.model.runtime.State.PAUSE),
    RECOVER(com.bytedance.atp.domain.model.runtime.State.PAUSE,com.bytedance.atp.domain.model.runtime.State.RUNNING);

    com.bytedance.atp.domain.model.runtime.State from;

    com.bytedance.atp.domain.model.runtime.State to;
}
