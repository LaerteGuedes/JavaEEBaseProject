package org.jeeouvaiouracha.listener;

import javax.faces.application.FacesMessage;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import java.util.List;

/**
 * Created by laerteguedes on 29/11/16.
 */
public class CustomPhaseListener implements PhaseListener{

    @Override
    public void afterPhase(PhaseEvent phaseEvent) {

    }

    @Override
    public void beforePhase(PhaseEvent phaseEvent) {
        List<FacesMessage> messages = phaseEvent.getFacesContext().getMessageList();

        if (messages.size() > 0){
            if (!phaseEvent.getPhaseId().equals(1)){
                phaseEvent.getFacesContext().getExternalContext().getFlash().setKeepMessages(true);

                for(FacesMessage message: messages){
                    phaseEvent.getFacesContext().addMessage(null, message);
                }
            }
        }
    }



    @Override
    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }
}
