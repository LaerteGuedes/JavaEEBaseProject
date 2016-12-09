package org.jeeouvaiouracha.domain;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 * Created by laerteguedes on 09/12/16.
 */
@Entity
@PrimaryKeyJoinColumn(name = "DISC_ID")
public class VideoDisc_2 extends Disc_2{

    private String director;
    private String language;

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
