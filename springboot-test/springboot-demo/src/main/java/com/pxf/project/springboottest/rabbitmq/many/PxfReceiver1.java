package com.pxf.project.springboottest.rabbitmq.many;//package com.pxf.project.springboottest.rabbitmq.many;
//
//import org.springframework.amqp.rabbit.annotation.RabbitHandler;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.stereotype.Component;
//
///**
// * @ClassName: pxfReceiver1
// * @Description: TODO
// * @Author panxiufeng
// * @Date 2018/8/11下午10:02
// */
//
//@Component
//@RabbitListener(queues="pxf")
//public class PxfReceiver1 {
//
//    @RabbitHandler
//    public void process(String pxf){
//        System.out.println("pxfReceiver1-------------->>"+pxf);
//    }
//}
