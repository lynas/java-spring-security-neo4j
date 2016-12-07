package com.lynas.service;

import com.lynas.model.AppUser;

/**
 * Created by lynas on 12/6/2016.
 */
public interface AppUserService {

    AppUser loadUserByUsername(String username);
}
