package com.flute.atp.domain.model.runtime.event;

import com.flute.atp.common.Category;
import com.flute.atp.common.VerificationReport;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FlowMatchedEvent extends FlowEvent {

    VerificationReport vp;

    public FlowMatchedEvent(VerificationReport vp) {
        this.vp = vp;
    }

    public FlowMatchedEvent(String ruleGroupId, String flowId, Category category, VerificationReport vp) {
        super(ruleGroupId, flowId, category);
        this.vp = vp;
    }
}
