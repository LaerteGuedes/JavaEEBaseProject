package org.jeeouvaiouracha.dao;

import org.jeeouvaiouracha.domain.AudioDisc;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by laerteguedes on 09/12/16.
 */
public class AudioDiscDaoImpl implements AudioDiscDao {

    @PersistenceContext
    EntityManager em;

    private Dao<AudioDisc> dao;

    @PostConstruct
    void init(){
        this.dao = new DaoImpl(em, AudioDisc.class);
    }

    @Override
    public void add(AudioDisc audioDisc) {
        dao.add(audioDisc);
    }

    @Override
    public void update(AudioDisc audioDisc) {
        dao.update(audioDisc);
    }

    @Override
    public void remove(AudioDisc audioDisc) {
        dao.remove(audioDisc);
    }

    @Override
    public AudioDisc findById(Long id) {
        return dao.findById(id);
    }

    @Override
    public List<AudioDisc> findAll() {
        return dao.findAll();
    }

    @Override
    public List<AudioDisc> findAllPaginate(int firstResult, int MaxResults) {
        return dao.findAllPaginate(firstResult, MaxResults);
    }
}
