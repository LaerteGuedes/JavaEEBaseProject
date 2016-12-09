package org.jeeouvaiouracha.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by laerteguedes on 09/12/16.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Disc_2 implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
