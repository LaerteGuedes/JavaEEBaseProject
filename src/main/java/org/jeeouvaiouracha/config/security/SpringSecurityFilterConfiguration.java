package org.jeeouvaiouracha.config.security;

import org.jeeouvaiouracha.config.JPAConfiguration;
import org.jeeouvaiouracha.dao.UserDaoImpl;
import org.jeeouvaiouracha.domain.User;
import org.jeeouvaiouracha.services.UserDetailsServiceImpl;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * Created by laerteguedes on 25/10/16.
 */
public class SpringSecurityFilterConfiguration extends AbstractSecurityWebApplicationInitializer {

    public SpringSecurityFilterConfiguration() {
        super(SecurityConfiguration.class, User.class, UserDaoImpl.class, UserDetailsServiceImpl.class, JPAConfiguration.class);
    }


}
