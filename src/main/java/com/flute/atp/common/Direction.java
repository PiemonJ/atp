package com.flute.atp.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Direction {

    TORUN(State.READY, State.RUNNING),
    INTERRUPT(State.RUNNING, State.INTERRUPT),
    PAUSE(State.RUNNING, State.PAUSE),
    RECOVER(State.PAUSE, State.RUNNING);

    State from;

    State to;
}
