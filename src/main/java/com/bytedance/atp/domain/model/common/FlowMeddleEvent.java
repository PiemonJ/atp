package com.bytedance.atp.domain.model.common;

import com.bytedance.atp.domain.model.runtime.State;

/**
 * 该事件用于人工干预Flow的执行
 *
 * 使用乐观锁【from -> to】
 */
public class FlowMeddleEvent {

    public String groupId;

    public String flowId;

    public State from;

    public State to;
}
