package com.lynas.service.impl;

import com.lynas.model.AppUser;
import com.lynas.repo.AppUserRepo;
import com.lynas.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by lynas on 12/6/2016.
 */

@Service("appUserService")
public class AppUserServiceImpl implements AppUserService{

    private AppUserRepo appUserRepo;

    @Autowired
    public AppUserServiceImpl(AppUserRepo appUserRepo) {
        this.appUserRepo = appUserRepo;
    }

    @Transactional
    @Override
    public AppUser loadUserByUsername(String username) {
        return appUserRepo.findByUsername(username);
    }
}
