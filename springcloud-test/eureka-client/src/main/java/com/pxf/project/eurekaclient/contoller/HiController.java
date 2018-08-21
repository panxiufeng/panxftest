package com.pxf.project.eurekaclient.contoller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hi")
public class HiController {

    @Value("${server.port}")
    String port;

    @RequestMapping("/index")
    @HystrixCommand(fallbackMethod = "hiError")
    public String index(@RequestParam(value = "name", defaultValue = "pxf--client-hi") String name){
        return "hi " + name + " ,i am from port:" + port;
    }

    public String hiError(String name) {
        return "hi,"+name+",sorry,error!";
    }
}
