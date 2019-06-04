package com.flute.atp.domain.model.report;

import com.bytedance.atp.common.*;
import com.flute.atp.domain.model.AggregateRoot;
import com.flute.atp.domain.model.report.event.ReportingTerminatedEvent;
import com.flute.atp.common.Category;
import com.flute.atp.common.State;
import com.flute.atp.common.VerificationReport;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * 报表
 *
 */
@Setter
@Getter
@Document
@NoArgsConstructor
@AllArgsConstructor
public class Reporting extends AggregateRoot {

    public Category category;

    public String ruleGroupId;

    public String flowId;

    public Clock clock;

    public List<VerificationReport> detail = new ArrayList<>();

    public boolean whetherInterrupt;

    public boolean whetherTrap;

    public boolean whetherTerminal;


    public boolean whetherStateFinal(){
        return whetherTerminal || whetherTrap || whetherInterrupt;
    }


    public void rich(VerificationReport vp, State state){
        switch (state){
            case RUNNING:
                detail.add(vp);
                break;
            case TRAP:
                detail.add(vp);
                whetherTrap = true;
                break;
            case INTERRUPT:
                whetherInterrupt = true;
                break;
            case DONE:
                clock.setFlowTerminal(Calendar.getInstance().getTime());
                whetherTerminal = true;
                ReportingTerminatedEvent event = new ReportingTerminatedEvent(ruleGroupId,flowId,category);
                events.add(event);
                break;
            case PAUSE:
                break;
            case READY:
                break;



        }

    }

}
