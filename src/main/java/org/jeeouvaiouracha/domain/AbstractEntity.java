package org.jeeouvaiouracha.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by laerteguedes on 09/12/16.
 */
@MappedSuperclass
public abstract class AbstractEntity implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
