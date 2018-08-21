package com.pxf.project.springbootrabbitmq.many;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName: pxfReceiver2
 * @Description: TODO
 * @Author panxiufeng
 * @Date 2018/8/11下午10:06
 */
@Component
@RabbitListener(queues = "pxf")
public class PxfReceiver2 {

    @RabbitHandler
    public void process(String pxf){
        System.out.println("pxfReceiver2-------------->>"+pxf);
    }
}
