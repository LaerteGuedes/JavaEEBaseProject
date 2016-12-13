package org.jeeouvaiouracha.dao;

import org.jeeouvaiouracha.domain.AbstractEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by laerteguedes on 20/10/16.
 */
public class DaoImpl<T extends AbstractEntity> implements Dao<T>{

    private final Class<T> classe;

    @PersistenceContext
    protected EntityManager em;

    public DaoImpl() {
        this.classe = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public void add(T t) {
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
