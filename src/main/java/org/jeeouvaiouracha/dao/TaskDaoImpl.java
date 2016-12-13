package org.jeeouvaiouracha.dao;

import org.jeeouvaiouracha.domain.Task;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by laerteguedes on 09/12/16.
 */
@Named
public class TaskDaoImpl extends DaoImpl<Task> implements TaskDao {

    @PersistenceContext
    EntityManager em;

}
