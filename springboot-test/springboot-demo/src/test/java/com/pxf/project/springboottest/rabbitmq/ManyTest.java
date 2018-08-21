package com.pxf.project.springboottest.rabbitmq;//package com.pxf.project.springboottest.rabbitmq;
//
//import com.pxf.project.springboottest.rabbitmq.many.PxfSender1;
//import com.pxf.project.springboottest.rabbitmq.many.PxfSender2;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
///**
// * @ClassName: ManyTest
// * @Description: TODO
// * @Author panxiufeng
// * @Date 2018/8/11下午10:09
// */
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class ManyTest {
//
//    @Autowired
//    private PxfSender1 pxfSender1;
//
//    @Autowired
//    private PxfSender2 pxfSender2;
//
//    @Test
//    public void oneToMany() throws Exception {
//        for (int i=0;i<100;i++){
//            pxfSender1.send(i);
//        }
//    }
//
//    @Test
//    public void manyToMany() throws Exception {
//        for (int i=0;i<100;i++){
//            pxfSender1.send(i);
//            pxfSender2.send(i);
//        }
//    }
//}
