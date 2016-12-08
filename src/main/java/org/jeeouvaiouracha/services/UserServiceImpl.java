package org.jeeouvaiouracha.services;

import org.jeeouvaiouracha.dao.UserDao;
import org.jeeouvaiouracha.domain.User;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by laerteguedes on 25/11/16.
 */
@Stateless
public class UserServiceImpl implements UserService {

    @Inject
    private UserDao dao;

    @Override
    public void add(User user) {
        dao.add(user);
    }

    @Override
    public void update(User user) {
        dao.update(user);
    }

    @Override
    public List<User> getAll() {
        return dao.findAll();
    }

    @Override
    public User findById(Long id) {
        return dao.findById(id);
    }

    @Override
    public void remove(User user) {
        dao.remove(user);
    }
}
