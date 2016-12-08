package org.jeeouvaiouracha.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * Created by laerteguedes on 07/12/16.
 */
@Embeddable
public class Person implements Serializable {

    private String name;
    private String phone;
    private String profession;
    private LocalDate birthday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}
