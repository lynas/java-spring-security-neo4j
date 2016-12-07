package com.lynas.service.impl;

import com.lynas.config.SpringSecurityUser;
import com.lynas.model.AppUser;
import com.lynas.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by lynas on 12/6/2016
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService{

    private AppUserService appUserService;

    @Autowired
    public UserDetailsServiceImpl(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        AppUser appUser = appUserService.loadUserByUsername(s);

        /*AppUser appUser = new AppUser();
        appUser.setUsername("admin");
        appUser.setPassword("$2a$10$3mUSOw6gya8AeNnzL7qiaO2p9qeko.rWVpRpRdZQ4SoICglyGQVHa");
        appUser.setAuthorities("ROLE_USER, ROLE_ADMIN");*/


        if (null == appUser) {
            throw new UsernameNotFoundException("No user found with username '%s'" + s);
        }else {
            return new SpringSecurityUser(
                    appUser.getId(),
                    appUser.getUsername(),
                    appUser.getPassword(),
                    null,
                    null,
                    AuthorityUtils.commaSeparatedStringToAuthorityList(appUser.getAuthorities())
            );
        }
    }
}
