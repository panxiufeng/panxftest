package com.pxf.project.springboottest.springscurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {


    @RequestMapping("/loginPage")
    public String loginPage(){

        return "/login";
    }

    @RequestMapping("/login")
    public String login(){

        return "/login";
    }

    @RequestMapping("/index")
    public String index(){

        return "/index";
    }
    @RequestMapping("/logout")
    public String logout(){

        return "/logout";
    }

}
