package org.jeeouvaiouracha.services;

import org.jeeouvaiouracha.dao.AudioDiscDao;
import org.jeeouvaiouracha.domain.AudioDisc;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by laerteguedes on 09/12/16.
 */
@Stateless
public class AudioDiscServiceImpl implements AudioDiscService {

    @Inject
    private AudioDiscDao dao;

    @Override
    public void add(AudioDisc audioDisc) {
        dao.add(audioDisc);
    }

    @Override
    public void update(AudioDisc audioDisc) {
        dao.update(audioDisc);
    }

    @Override
    public List<AudioDisc> getAll() {
        return dao.findAll();
    }

    @Override
    public void remove(AudioDisc audioDisc) {
        dao.remove(audioDisc);
    }

    @Override
    public AudioDisc findById(Long id) {
        return dao.findById(id);
    }
}
