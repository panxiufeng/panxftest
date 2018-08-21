package com.pxf.project.springbootrabbitmq;

import com.pxf.project.springbootrabbitmq.hello.HelloSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author panxiufeng
 * @ClassName: HelloTest
 * @Description: TODO
 * @Date 2018/8/11下午4:17
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootRabbitmqApplication.class)
public class HelloTest {


    @Autowired
    private HelloSender helloSender;

    @Test
    public void hello() throws Exception {
        helloSender.send();
    }


}
