package com.pxf.project.springbootredis;

import com.pxf.project.springbootredis.util.RedisUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootRedisApplication.class)
public class MyTest {

    @Autowired
    private RedisUtil redisUtil;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void test() throws Exception {
        Object aaa = redisUtil.get("aaa");
        System.out.println("----->"+aaa);
    }


}
