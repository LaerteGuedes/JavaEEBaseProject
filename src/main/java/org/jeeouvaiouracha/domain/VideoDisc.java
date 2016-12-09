package org.jeeouvaiouracha.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;

/**
 * Created by laerteguedes on 09/12/16.
 */
@Entity
@DiscriminatorValue("VIDEO")
public class VideoDisc extends Disc implements Serializable{

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

    @Override
    public String toString() {
        return "VideoDisc{" +
                "director='" + director + '\'' +
                ", language='" + language + '\'' +
                '}';
    }
}
