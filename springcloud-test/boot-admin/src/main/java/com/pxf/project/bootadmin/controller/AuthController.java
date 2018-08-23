package com.pxf.project.bootadmin.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @RequestMapping("/index")
    public  String  index(){
        System.out.println("-----------------------------");
        return "access auth/index success";
    }
}
