package org.jeeouvaiouracha.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;

/**
 * Created by laerteguedes on 09/12/16.
 */
@Entity
@DiscriminatorValue("AUDIO")
public class AudioDisc extends Disc implements Serializable{

    private Integer noOfSongs;
    private String artist;

    public Integer getNoOfSongs() {
        return noOfSongs;
    }

    public void setNoOfSongs(Integer noOfSongs) {
        this.noOfSongs = noOfSongs;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    @Override
    public String toString() {
        return "AudioDisc{" +
                "noOfSongs=" + noOfSongs +
                ", artist='" + artist + '\'' +
                '}';
    }
}
