package com.lynas.controller;

import com.lynas.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lynas on 12/6/2016
 */
@Controller
public class HomeController {

    private AppUserService appUserService;

    @Autowired
    public HomeController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @RequestMapping("/")
    public String home(){
        System.out.println(appUserService.loadUserByUsername("admin"));

        return "home";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

}
