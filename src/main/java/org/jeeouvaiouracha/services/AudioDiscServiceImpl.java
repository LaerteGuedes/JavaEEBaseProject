package org.jeeouvaiouracha.services;

import org.jeeouvaiouracha.dao.AudioDiscDao;
import org.jeeouvaiouracha.domain.AudioDisc;
import org.jeeouvaiouracha.domain.AudioDisc_2;

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
    public void add(AudioDisc_2 audioDisc) {
        dao.add(audioDisc);
    }

    @Override
    public void update(AudioDisc_2 audioDisc) {
        dao.update(audioDisc);
    }

    @Override
    public List<AudioDisc_2> getAll() {
        return dao.findAll();
    }

    @Override
    public void remove(AudioDisc_2 audioDisc) {
        dao.remove(audioDisc);
    }

    @Override
    public AudioDisc_2 findById(Long id) {
        return dao.findById(id);
    }
}
