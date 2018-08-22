package com.pxf.project.dubboconsumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pxf.project.dubboapi.service.DubboService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dubbo")
public class DubboController {

    private static Logger logger = LoggerFactory.getLogger(DubboController.class);

    @Reference(version = "1.0.0")
    DubboService dubboService;

    @RequestMapping("sayHello")
    public String sayHello() {
        logger.info("-------------> DubboController 开始调用"  );
       String str =  dubboService.sayHello("consumer 请求服务");
        logger.info(str );
        return str;
    }

}
