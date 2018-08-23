package com.pxf.project.bootadmin.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hi")
public class HiController {

    @RequestMapping("/index")
    public  String  index(){
        System.out.println("-----------------------------");
        return "access hi/index success";
    }

}
