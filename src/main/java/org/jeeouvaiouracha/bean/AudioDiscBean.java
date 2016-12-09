package org.jeeouvaiouracha.bean;

import org.jeeouvaiouracha.domain.AudioDisc;
import org.jeeouvaiouracha.services.AudioDiscService;

import javax.faces.application.FacesMessage;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by laerteguedes on 09/12/16.
 */
@Named
@ViewScoped
public class AudioDiscBean implements Serializable{

    @Inject
    FacesContext fc;

    @Inject
    private AudioDiscService service;

    private AudioDisc audioDisc = new AudioDisc();

    public AudioDisc getAudioDisc() {
        return audioDisc;
    }

    public void setAudioDisc(AudioDisc audioDisc) {
        this.audioDisc = audioDisc;
    }

    public String add(AudioDisc audioDisc){
        service.add(audioDisc);

        fc.getExternalContext().getFlash().setKeepMessages(true);
        fc.addMessage(null, new FacesMessage("Disco salvo com sucesso!"));

        return null;
    }


}
