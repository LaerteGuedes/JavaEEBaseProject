package org.jeeouvaiouracha.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by laerteguedes on 13/12/16.
 */
@Entity
@Table(name = "permission")
public class Permission extends AbstractEntity implements Serializable {

    @NotNull
    private String name;

    @ManyToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

}
