package org.jeeouvaiouracha.services;

import org.jeeouvaiouracha.dao.TaskDao;
import org.jeeouvaiouracha.domain.Task;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by laerteguedes on 09/12/16.
 */
@Stateless
public class TaskServiceImpl implements TaskService {

    @Inject
    private TaskDao dao;

    @Override
    public void add(Task task) {
        dao.add(task);
    }

    @Override
    public void update(Task task) {
        dao.update(task);
    }

    @Override
    public List<Task> getAll() {
        return dao.findAll();
    }

    @Override
    public Task findById(Long id) {
        return dao.findById(id);
    }

    @Override
    public void remove(Task task) {
        dao.remove(task);
    }
}
