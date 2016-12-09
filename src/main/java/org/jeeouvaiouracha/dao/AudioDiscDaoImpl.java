package org.jeeouvaiouracha.dao;

import org.jeeouvaiouracha.domain.AudioDisc_2;

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

    private Dao<AudioDisc_2> dao;

    @PostConstruct
    void init(){
        this.dao = new DaoImpl(em, AudioDisc_2.class);
    }
    @Override
        public void add(AudioDisc_2 audioDisc) {
        dao.add(audioDisc);
    }

    @Override
    public void update(AudioDisc_2 audioDisc) {
        dao.update(audioDisc);
    }

    @Override
    public void remove(AudioDisc_2 audioDisc) {
        dao.remove(audioDisc);
    }

    @Override
    public AudioDisc_2 findById(Long id) {
        return dao.findById(id);
    }

    @Override
    public List<AudioDisc_2> findAll() {
        return dao.findAll();
    }

    @Override
    public List<AudioDisc_2> findAllPaginate(int firstResult, int MaxResults) {
        return dao.findAllPaginate(firstResult, MaxResults);
    }
}
