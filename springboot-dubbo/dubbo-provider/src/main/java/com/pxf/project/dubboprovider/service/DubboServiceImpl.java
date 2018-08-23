package com.pxf.project.dubboprovider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.pxf.project.dubboapi.service.DubboService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service(version = "1.0.0")
public class DubboServiceImpl implements DubboService {

    private static Logger logger = LoggerFactory.getLogger(DubboServiceImpl.class);
    private static int count = 0;
    @Override
    public String sayHello(String name) {
        count = ++count;
        logger.info("到达provider-----------------> name：" + name +"  ;count："+count);
        return "provider返回-----------------> name：" + name +"  ;count："+count;
    }
}
