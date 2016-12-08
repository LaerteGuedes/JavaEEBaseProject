package org.jeeouvaiouracha.producers;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;

/**
 * Created by laerteguedes on 18/10/16.
 */
public class ContextProducer {

    @Produces
    @RequestScoped
    public FacesContext producesFacesContext(){
        return FacesContext.getCurrentInstance();
    }

}
