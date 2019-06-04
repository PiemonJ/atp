package com.flute.atp.domain.model.runtime.event;

import com.flute.atp.common.Category;
import com.flute.atp.common.VerificationReport;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FlowNonMatchedEvent extends FlowEvent {

    public VerificationReport vp;

    public FlowNonMatchedEvent(VerificationReport vp) {
        this.vp = vp;
    }

    public FlowNonMatchedEvent(String ruleGroupId, String flowId, Category category, VerificationReport vp) {
        super(ruleGroupId, flowId, category);
        this.vp = vp;
    }
}
