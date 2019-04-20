package com.bytedance.atp.domain.model.common;

import com.bytedance.atp.common.Direction;
import com.bytedance.atp.common.State;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 该事件用于人工干预Flow的执行
 *
 * 使用乐观锁【from -> to】
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlowMeddleEvent {

    public String groupId;

    public String flowId;

    public State from;

    public State to;

    public static FlowMeddleEvent apply(String groupId, String flowId, Direction direction){

        return new FlowMeddleEvent(groupId,flowId,direction.getFrom(),direction.getTo());

    }
}
