package org.jeeouvaiouracha.domain;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 * Created by laerteguedes on 09/12/16.
 */
@Entity
@PrimaryKeyJoinColumn(name = "DISC_ID")
public class AudioDisc_2 extends Disc_2 {

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
}
