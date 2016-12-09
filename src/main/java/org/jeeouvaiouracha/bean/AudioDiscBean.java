package org.jeeouvaiouracha.bean;

import org.jeeouvaiouracha.domain.AudioDisc;
import org.jeeouvaiouracha.domain.AudioDisc_2;
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

    private AudioDisc_2 audioDisc = new AudioDisc_2();

    public AudioDisc_2 getAudioDisc() {
        return audioDisc;
    }

    public void setAudioDisc(AudioDisc_2 audioDisc) {
        this.audioDisc = audioDisc;
    }

    public String add(AudioDisc_2 audioDisc){
        service.add(audioDisc);

        fc.getExternalContext().getFlash().setKeepMessages(true);
        fc.addMessage(null, new FacesMessage("Disco salvo com sucesso!"));

        return null;
    }


}
