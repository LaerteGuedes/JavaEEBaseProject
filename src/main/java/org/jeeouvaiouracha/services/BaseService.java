package org.jeeouvaiouracha.services;

import java.util.List;

/**
 * Created by laerteguedes on 24/10/16.
 */
public interface BaseService<T> {

    void add(T t);

    void update(T t);

    List<T> getAll();

    T findById(Long id);

    void remove(T t);

}
