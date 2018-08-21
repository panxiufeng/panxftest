package com.pxf.project.springboottest.rabbitmq.object;//package com.pxf.project.springboottest.rabbitmq.object;
//
//import com.pxf.project.springboottest.common.model.User;
//import org.springframework.amqp.core.AmqpTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
///**
// * @ClassName: ObjectSender
// * @Description: TODO
// * @Author panxiufeng
// * @Date 2018/8/11下午10:19
// */
//@Component
//public class ObjectSender {
//
//    @Autowired
//    private AmqpTemplate rabbitTemplate;
//
//    public void send(User user) {
//        System.out.println("Sender object: " + user.toString());
//        this.rabbitTemplate.convertAndSend("object", user);
//    }
//
//}
