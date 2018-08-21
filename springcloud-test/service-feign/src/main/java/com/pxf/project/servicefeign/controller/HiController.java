package com.pxf.project.servicefeign.controller;

import com.pxf.project.servicefeign.client.ServiceHiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hi")
public class HiController {

    //编译器报错，无视。 因为这个Bean是在程序启动的时候注入的，编译器感知不到，所以报错。
    @Autowired
    ServiceHiClient serviceHiClient;

    @GetMapping(value = "/index")
    public String index(@RequestParam(value = "name", defaultValue = "pxf--feign") String name) {
        String str =  serviceHiClient.sayHiFromClientOne( name );
        return str;
    }
}
