package com.pxf.project.springboottest.mybatis;

import com.pxf.project.springboottest.SpringbootTestApplication;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/** 
* UserAuthIdSymbolController Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 9, 2018</pre> 
* @version 1.0 
*/

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootTestApplication.class)
@WebAppConfiguration
public class MybatisControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void before() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    } 
    
    @After
    public void after() throws Exception { 
    } 
    
    /** 
    * 
    * Method: findSymbol(@PathVariable("authId") String authId) 
    * 
    */ 
    @Test
    public void testFindSymbol() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/myisbat/findSymbol/AUTH00001")
//                .param("param","paramValue")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    } 
    
        
    
} 
