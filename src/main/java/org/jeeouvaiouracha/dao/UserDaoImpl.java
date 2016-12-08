package org.jeeouvaiouracha.dao;

import org.jeeouvaiouracha.domain.User;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

/**
 * Created by laerteguedes on 25/11/16.
 */
@Named
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    EntityManager em;

    private Dao<User> dao;

    @PostConstruct
    void init(){
        this.dao = new DaoImpl(em, User.class);
    }

    @Override
    public void add(User user) {
        dao.add(user);
    }

    @Override
    public void update(User user) {
        dao.update(user);
    }

    @Override
    public void remove(User user) {
        dao.remove(user);
    }

    @Override
    public User findById(Long id) {
        return dao.findById(id);
    }

    @Override
    public List<User> findAll() {
        return dao.findAll();
    }

    @Override
    public List<User> findAllPaginate(int firstResult, int maxResults) {
        return findAllPaginate(firstResult,maxResults);
    }

    @Override
    public User findByEmail(String email) {
        Query query = em.createQuery("SELECT u FROM User WHERE u.email = :email");
        query.setParameter("email", email);

        try{
            return (User) query.getSingleResult();
        }catch(Exception ex){
            return null;
        }
    }
}
