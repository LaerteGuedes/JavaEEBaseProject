package org.jeeouvaiouracha.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by laerteguedes on 09/12/16.
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class AbstractEntity implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
