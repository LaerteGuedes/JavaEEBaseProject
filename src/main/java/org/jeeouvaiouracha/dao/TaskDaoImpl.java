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
public class TaskDaoImpl implements TaskDao {

    @PersistenceContext
    EntityManager em;

    private Dao<Task> dao;

    @PostConstruct
    void init(){
        dao = new DaoImpl(em, Task.class);
    }

    @Override
    public void add(Task task) {
        dao.add(task);
    }

    @Override
    public void update(Task task) {
        dao.update(task);
    }

    @Override
    public void remove(Task task) {
        dao.remove(task);
    }

    @Override
    public Task findById(Long id) {
        return dao.findById(id);
    }

    @Override
    public List<Task> findAll() {
        return dao.findAll();
    }

    @Override
    public List<Task> findAllPaginate(int firstResult, int MaxResults) {
        return dao.findAllPaginate(firstResult, MaxResults);
    }
}
