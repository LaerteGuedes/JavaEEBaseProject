package org.jeeouvaiouracha.domain;

import org.springframework.security.crypto.bcrypt.BCrypt;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by laerteguedes on 25/11/16.
 */
@Entity
@Table(name = "user")
public class User extends AbstractEntity implements Serializable{

    @Embedded
    private Person person = new Person();

    @NotNull
    private String email;
    @NotNull
    @Size(min = 5)
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = getBcryptPassword(password);
    }

    private String getBcryptPassword(String senha){
        String salt = BCrypt.gensalt(12);
        return BCrypt.hashpw(senha, salt);
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (getPerson() != null ? !getPerson().equals(user.getPerson()) : user.getPerson() != null) return false;
        if (!getEmail().equals(user.getEmail())) return false;

        return getPassword().equals(user.getPassword());

    }

    @Override
    public int hashCode() {
        int result = getPerson() != null ? getPerson().hashCode() : 0;
        result = 31 * result + getEmail().hashCode();
        result = 31 * result + getPassword().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
