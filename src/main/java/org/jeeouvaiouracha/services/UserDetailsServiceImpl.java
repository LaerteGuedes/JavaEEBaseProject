package org.jeeouvaiouracha.services;

import org.jeeouvaiouracha.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by laerteguedes on 25/10/16.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        org.jeeouvaiouracha.domain.User u = userDao.findByEmail(username);

        if (u == null){
            throw new UsernameNotFoundException("Usuário não encontrado");
        }

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        // grantedAuthorities.add(new SimpleGrantedAuthority(u.getPerfil().toString()));

        return new User(u.getEmail(), u.getPassword(), grantedAuthorities);
    }
}
