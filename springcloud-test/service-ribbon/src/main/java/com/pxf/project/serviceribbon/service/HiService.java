package com.pxf.project.serviceribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HiService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "hiError")
    public String indexService(String name) {
        String result = restTemplate.getForObject("http://service-hi/hi/index?name="+name,String.class);
        return result;
    }

    public String hiError(String name) {
        return "hi,"+name+",sorry,error!";
    }


}
