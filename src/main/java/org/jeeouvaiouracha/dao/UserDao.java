package org.jeeouvaiouracha.dao;

import org.jeeouvaiouracha.domain.User;

/**
 * Created by laerteguedes on 25/11/16.
 */
public interface UserDao extends Dao<User> {

    User findByEmail(String email);

}
