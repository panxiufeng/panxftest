package com.pxf.project.springbootrabbitmq.object;

import com.pxf.project.springbootrabbitmq.model.User;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName: ObjectReceiver
 * @Description: TODO
 * @Author panxiufeng
 * @Date 2018/8/11下午10:21
 */

@Component
@RabbitListener(queues = "object")
public class ObjectReceiver {

    @RabbitHandler
    public void process(User user) {
        System.out.println("Receiver object ------------>>" + user);
    }

}
