package com.pxf.project.serviceribbon.controller;

import com.pxf.project.serviceribbon.service.HiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hi")
public class HiController {

    @Autowired
    private HiService hiService;

    @RequestMapping("/index")
    public String index(@RequestParam(value = "name", defaultValue = "pxf--ribbon") String name){
        String str = hiService.indexService(name);
        return str;
    }

}
