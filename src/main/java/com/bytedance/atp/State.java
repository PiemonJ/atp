package com.bytedance.atp;

public enum State {

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
    };


    public abstract void action(FlowId flowId);

}
