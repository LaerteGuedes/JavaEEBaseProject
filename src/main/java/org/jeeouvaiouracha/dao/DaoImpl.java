package org.jeeouvaiouracha.dao;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

/**
 * Created by laerteguedes on 20/10/16.
 */
public class DaoImpl<T> implements Dao<T>{

    private final Class<T> classe;
    private EntityManager em;

    public DaoImpl(EntityManager em, Class<T> classe) {
        this.em = em;
        this.classe = classe;
    }

    @Override
    public void add(T t) {
        System.out.println("ENTITY MANAGER "+em);
        em.persist(t);
    }

    @Override
    public void update(T t) {
        em.merge(t);
    }

    @Override
    public T findById(Long id) {
        return em.find(classe, id);
    }

    @Override
    public List<T> findAll() {
        CriteriaQuery<T> query = em.getCriteriaBuilder().createQuery(classe);
        query.select(query.from(classe));

        return em.createQuery(query).getResultList();
    }

    @Override
    public List<T> findAllPaginate(int firstResult, int maxResults) {
        CriteriaQuery<T> query = em.getCriteriaBuilder().createQuery(classe);
        query.select(query.from(classe));

        return em.createQuery(query).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

    @Override
    public void remove(T t) {
        em.remove(em.merge(t));
    }

}
