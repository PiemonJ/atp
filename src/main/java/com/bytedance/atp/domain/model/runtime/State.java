package com.bytedance.atp.domain.model.runtime;

import com.bytedance.atp.FlowId;

public enum State {

    READY{
        @Override
        public void action(FlowId flowId) {

        }
    },

    RUNNING{
        @Override
        public void action(FlowId flowId) {

        }
    },
    INTERRUPT{
        @Override
        public void action(FlowId flowId) {

        }
    },
    PAUSE{
        @Override
        public void action(FlowId flowId) {

        }
    },
    DONE{
        @Override
        public void action(FlowId flowId) {

        }
    };


    public abstract void action(FlowId flowId);

}
