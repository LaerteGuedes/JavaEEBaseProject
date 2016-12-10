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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (getName() != null ? !getName().equals(person.getName()) : person.getName() != null) return false;
        if (getPhone() != null ? !getPhone().equals(person.getPhone()) : person.getPhone() != null) return false;
        if (getProfession() != null ? !getProfession().equals(person.getProfession()) : person.getProfession() != null)
            return false;
        return !(getBirthday() != null ? !getBirthday().equals(person.getBirthday()) : person.getBirthday() != null);

    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getPhone() != null ? getPhone().hashCode() : 0);
        result = 31 * result + (getProfession() != null ? getProfession().hashCode() : 0);
        result = 31 * result + (getBirthday() != null ? getBirthday().hashCode() : 0);
        return result;
    }
}
