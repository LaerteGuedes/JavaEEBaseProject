package org.jeeouvaiouracha.config.security;

import org.jeeouvaiouracha.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by laerteguedes on 25/10/16.
 */
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl usuarioDetailsService;

    protected void configure(HttpSecurity http) throws Exception {
        
        System.out.println("\nSECURITY CONFIGURATION\n");
        System.out.println("\nUsuario details Service \n"+usuarioDetailsService.getClass());

        http.authorizeRequests().antMatchers("/user/new.phtml").permitAll()
                .antMatchers("/login.xhtml").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/resources/**").permitAll()
                .antMatchers("/automovel/**").permitAll()
                .antMatchers("/admin/*").hasRole("ADMINISTRADOR")
                .anyRequest()
                .authenticated().and()
                .formLogin()
                .loginPage("/login.xhtml")
                .loginProcessingUrl("/j_spring_security_check")
                .failureUrl("/login.xhtml?error=true")
                .defaultSuccessUrl("/user/list.xhtml")
                .and().csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.userDetailsService(usuarioDetailsService).passwordEncoder(
                new BCryptPasswordEncoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**").antMatchers("/javax.faces.resource/**");

    }

}
