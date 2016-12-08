package org.jeeouvaiouracha.listener;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

/**
 * Created by laerteguedes on 29/11/16.
 */
public class CustomPhaseListener implements PhaseListener{

    @Override
    public void afterPhase(PhaseEvent phaseEvent) {
        
    }

    @Override
    public void beforePhase(PhaseEvent phaseEvent) {
        System.out.println("PHASE EVENT "+phaseEvent.getPhaseId());
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }
}
