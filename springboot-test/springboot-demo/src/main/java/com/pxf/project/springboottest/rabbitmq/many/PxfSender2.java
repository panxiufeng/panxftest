package com.pxf.project.springboottest.rabbitmq.many;//package com.pxf.project.springboottest.rabbitmq.many;
//
//import org.springframework.amqp.core.AmqpTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
///**
// * @ClassName: pxfSender2
// * @Description: TODO
// * @Author panxiufeng
// * @Date 2018/8/11下午10:04
// */
//@Component
//public class PxfSender2 {
//    @Autowired
//    private AmqpTemplate rabbitTemplate;
//
//    public void send(int i) {
//        String context = "spirng boot pxf queue"+" ****** "+i;
//        System.out.println("pxfSender2 : " + context);
//        this.rabbitTemplate.convertAndSend("pxf2", context);
//    }
//}
