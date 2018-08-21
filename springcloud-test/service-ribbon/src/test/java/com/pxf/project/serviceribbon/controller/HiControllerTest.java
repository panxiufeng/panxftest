package com.pxf.project.serviceribbon.controller;

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
* HelloController Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 14, 2018</pre> 
* @version 1.0 
*/
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class HiControllerTest {

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
    * Method: index(@RequestParam(value = "name", defaultValue = "panxiufeng") String name) 
    * 
    */ 
    @Test
    public void testIndex() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/hello/index")
                .param("name","myName")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    } 
    
        
    
} 
