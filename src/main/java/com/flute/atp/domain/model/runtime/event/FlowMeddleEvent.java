package com.flute.atp.domain.model.runtime.event;

import com.flute.atp.common.Direction;
import com.flute.atp.common.State;
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
