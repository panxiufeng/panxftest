package com.pxf.project.springboottest.hello;

import com.pxf.project.springboottest.SpringbootTestApplication;
import com.pxf.project.springboottest.hello.controller.HelloController;
import com.pxf.project.springboottest.redis.RedisHelperImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/** 
* HelloController Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 8, 2018</pre> 
* @version 1.0 
*/

//SpringBoot1.4版本之前用的是SpringJUnit4ClassRunner.class
@RunWith(SpringRunner.class)
//SpringBoot1.4版本之前用的是@SpringApplicationConfiguration(classes = Application.class)
@SpringBootTest(classes = SpringbootTestApplication.class)
//测试环境使用，用来表示测试环境使用的ApplicationContext将是WebApplicationContext类型的
@WebAppConfiguration
public class HelloControllerTest {

    private final static Logger logger = LoggerFactory.getLogger(HelloControllerTest.class);

    private MockMvc mvc;
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisHelperImpl redisHelper;

    @Before
    public void before() throws Exception {
//        MockMvcBuilders.webAppContextSetup(WebApplicationContext context)：指定WebApplicationContext，将会从该上下文获取相应的控制器并得到相应的MockMvc；
//        MockMvcBuilders.standaloneSetup(Object... controllers)：通过参数指定一组控制器，这样就不需要从上下文获取了；

        mvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @After
    public void after() throws Exception {
    }


    /**
     * 1、mockMvc.perform执行一个请求。
     * 2、MockMvcRequestBuilders.get("XXX")构造一个请求。
     * 3、ResultActions.param添加请求传值
     * 4、ResultActions.accept(MediaType.TEXT_HTML_VALUE))设置返回类型
     * 5、ResultActions.andExpect添加执行完成后的断言。
     * 6、ResultActions.andDo添加一个结果处理器，表示要对结果做点什么事情
     *   比如此处使用MockMvcResultHandlers.print()输出整个响应结果信息。
     * 5、ResultActions.andReturn表示执行完成后返回相应的结果。
     */

    @Test
    public void testIndex() throws Exception {

        mvc.perform(MockMvcRequestBuilders.get("/hello/index").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void testRedisCache() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/hello/redisCache/id/name_name")
                .param("param","paramValue")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void testDel() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/hello/del/id").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }


    @Test
    public void testSayHello() throws Exception
    {
        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.get( "/sayHello" );
        mockHttpServletRequestBuilder.param( "name", "tom" ).param( "password", "jessica" );
        ResultActions resultActions = mockMvc.perform( mockHttpServletRequestBuilder );
        resultActions.andExpect( MockMvcResultMatchers.status().isOk() );

    }


} 
