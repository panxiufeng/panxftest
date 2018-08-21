package com.pxf.project.springbootrabbitmq.many;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassName: pxfSender1
 * @Description: TODO
 * @Author panxiufeng
 * @Date 2018/8/11下午10:01
 */

@Component
public class PxfSender1 {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(int i) {
        String context = "spirng boot pxf queue"+" ****** "+i;
        System.out.println("pxfSender1 : " + context);
        this.rabbitTemplate.convertAndSend("pxf1", context);
    }
}
