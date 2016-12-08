package org.jeeouvaiouracha.config;

import org.springframework.context.annotation.Bean;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;

/**
 * Created by laerteguedes on 25/10/16.
 */
public class JPAConfiguration {

    @Bean
    public EntityManagerFactory emf() throws NamingException {
        Context ctx = new InitialContext();

        EntityManagerFactory lookup = (EntityManagerFactory) ctx.lookup("java:comp/env/persistence/agoravai");
        return lookup;
    }

}
