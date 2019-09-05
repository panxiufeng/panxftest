/**
 * Software License Declaration.
 * <p>
 * wandaph.com, Co,. Ltd.
 * Copyright ? 2017 All Rights Reserved.
 * <p>
 * Copyright Notice
 * This documents is provided to wandaph contracting agent or authorized programmer only.
 * This source code is written and edited by wandaph Co,.Ltd Inc specially for financial
 * business contracting agent or authorized cooperative company, in order to help them to
 * install, programme or central control in certain project by themselves independently.
 * <p>
 * Disclaimer
 * If this source code is needed by the one neither contracting agent nor authorized programmer
 * during the use of the code, should contact to wandaph Co,. Ltd Inc, and get the confirmation
 * and agreement of three departments managers  - Research Department, Marketing Department and
 * Production Department.Otherwise wandaph will charge the fee according to the programme itself.
 * <p>
 * Any one,including contracting agent and authorized programmer,cannot share this code to
 * the third party without the agreement of wandaph. If Any problem cannot be solved in the
 * procedure of programming should be feedback to wandaph Co,. Ltd Inc in time, Thank you!
 */
package com.pxf.project;

import com.pxf.project.service.ILogin;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author panxiufeng
 * @version Id: App.java, v 0.1 2019/6/5 11:29 panxiufeng Exp $$
 */
public class App {

    public static void main(String[] args) {

        ILogin login = null;

//        Resource resource = new ClassPathResource("spring-config.xml");
//        BeanFactory factory = new XmlBeanFactory(resource);
//        login = (ILogin)factory.getBean("loginService");


        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-config.xml");
//        ApplicationContext applicationContext=new FileSystemXmlApplicationContext("D:\\MyGit\\panxfGithub\\panxftest\\spring-code-test\\src\\main\\resources\\spring-config.xml");
        login = (ILogin) applicationContext.getBean("loginService");
        login.loginCheck("boy", "123");



    }
}