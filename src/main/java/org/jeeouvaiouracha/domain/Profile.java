package org.jeeouvaiouracha.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * Created by laerteguedes on 13/12/16.
 */
@Entity
@Table(name = "profile")
public class Profile extends AbstractEntity implements Serializable{

    @NotNull
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Profile profile = (Profile) o;

        if (getId() != null ? !getId().equals(profile.getId()) : profile.getId() != null) return false;
        return !(getName() != null ? !getName().equals(profile.getName()) : profile.getName() != null);

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        return result;
    }
}
