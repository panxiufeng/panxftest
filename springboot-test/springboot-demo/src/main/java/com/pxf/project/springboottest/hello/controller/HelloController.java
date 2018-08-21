package com.pxf.project.springboottest.hello.controller;

import com.pxf.project.springboottest.common.model.User;
import com.pxf.project.springboottest.redis.RedisHelperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.UUID;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @Value("${com.neo.title}")
    private String title;

    @Value("${com.neo.description}")
    private String description;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisHelperImpl redisHelper;


    @RequestMapping("/index")
    public String index(){
        return "hello springboot!!!  title:"+title+" , description="+description;
    }

    @RequestMapping("/getUser")
    public User getUser() {
        User user=new User();
        user.setName("小明");
        user.setPassword("xxxx");
        return user;
    }


    @Cacheable(value="userinfo",key="'userId_'+#id") //自动根据方法生成缓存,插入redis
    @RequestMapping(value = "/redisCache/{id}/{name}")
    public User redisCache(@PathVariable("id") String id, @PathVariable("name")String name, @RequestParam("param") String param) {

        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setAge(23);
        user.setPassword("12346");
        user.setSex("man");
        return user;
    }


    @CacheEvict(value="userinfo", key="'userId_'+#id")
    @RequestMapping(value = "/del/{id}")
    public void del(@PathVariable("id") String id) {
        // 删除user
        System.out.println("user删除");
    }

    @RequestMapping( value = "/sayHello")
    public String sayHello(HttpServletRequest httpServletRequest)
    {
        String name = httpServletRequest.getParameter( "name" );
        String password = httpServletRequest.getParameter( "password" );
        System.out.println( "用户名是:" + name + "密码是:" + password );
        return name+"--"+password;
    }

    /**  
    * SessionConfiguration  -->> redis 中会保存session
    */
    @RequestMapping("/uid")
    String uid(HttpSession session) {
        UUID uid = (UUID) session.getAttribute("uid");
        if (uid == null) {
            uid = UUID.randomUUID();
        }
        System.out.println("----->"+uid);
        session.setAttribute("uid", uid);
        return session.getId();
    }

}
