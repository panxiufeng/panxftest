package com.pxf.project.springboottest.redis;

import com.pxf.project.springboottest.SpringbootTestApplication;
import com.pxf.project.springboottest.common.model.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

/** 
* RedisHelperImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 9, 2018</pre> 
* @version 1.0 
*/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootTestApplication.class)
public class RedisHelperImplTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisHelperImpl redisHelper;

    @Before
    public void before() throws Exception { 
    } 
    
    @After
    public void after() throws Exception { 
    }

    @Test
    public void test() throws Exception {

//        基本写法
        stringRedisTemplate.opsForValue().set("aaa","111");
        Assert.assertEquals("111",stringRedisTemplate.opsForValue().get("aaa"));
        System.out.println(stringRedisTemplate.opsForValue().get("aaa"));
//        User user=new User();
//        user.setName("Alex");
//        user.setAge(22);
//        redisHelper.valuePut("Alex",user);
//        System.out.println(redisHelper.getValue("Alex"));
    }

    @Test
    public void testObj() throws Exception {

        User user=new User();
        user.setName("Alex");
        user.setAge(22);
        ValueOperations<String, User> operations=redisTemplate.opsForValue();
        operations.set("502", user);
        Thread.sleep(500);
        boolean exists=redisTemplate.hasKey("502");
        if(exists){
            System.out.println(redisTemplate.opsForValue().get("502"));
        }else{
            System.out.println("exists is false");
        }
        // Assert.assertEquals("aa", operations.get("com.neo.f").getUserName());
    }


    /**
    * 
    * Method: hashPut(String key, HK hashKey, T domain) 
    * 
    */ 
    @Test
    public void testHashPut() throws Exception {
    //TODO: Test goes here...
    } 
    
    /** 
    * 
    * Method: hashFindAll(String key) 
    * 
    */ 
    @Test
    public void testHashFindAll() throws Exception { 
    //TODO: Test goes here... 
    } 
    
    /** 
    * 
    * Method: hashGet(String key, HK hashKey) 
    * 
    */ 
    @Test
    public void testHashGet() throws Exception { 
    //TODO: Test goes here... 
    } 
    
    /** 
    * 
    * Method: hashRemove(String key, HK hashKey) 
    * 
    */ 
    @Test
    public void testHashRemove() throws Exception { 
    //TODO: Test goes here... 
    } 
    
    /** 
    * 
    * Method: listPush(String key, T domain) 
    * 
    */ 
    @Test
    public void testListPush() throws Exception { 
    //TODO: Test goes here... 
    } 
    
    /** 
    * 
    * Method: listUnshift(String key, T domain) 
    * 
    */ 
    @Test
    public void testListUnshift() throws Exception { 
    //TODO: Test goes here... 
    } 
    
    /** 
    * 
    * Method: listFindAll(String key) 
    * 
    */ 
    @Test
    public void testListFindAll() throws Exception { 
    //TODO: Test goes here... 
    } 
    
    /** 
    * 
    * Method: listLPop(String key) 
    * 
    */ 
    @Test
    public void testListLPop() throws Exception { 
    //TODO: Test goes here... 
    } 
    
    /** 
    * 
    * Method: valuePut(String key, T domain) 
    * 
    */ 
    @Test
    public void testValuePut() throws Exception { 
    //TODO: Test goes here... 
    } 
    
    /** 
    * 
    * Method: getValue(String key) 
    * 
    */ 
    @Test
    public void testGetValue() throws Exception { 
    //TODO: Test goes here... 
    } 
    
    /** 
    * 
    * Method: remove(String key) 
    * 
    */ 
    @Test
    public void testRemove() throws Exception { 
    //TODO: Test goes here... 
    } 
    
    /** 
    * 
    * Method: expirse(String key, long timeout, TimeUnit timeUnit) 
    * 
    */ 
    @Test
    public void testExpirse() throws Exception { 
    //TODO: Test goes here... 
    } 
    
        
}
