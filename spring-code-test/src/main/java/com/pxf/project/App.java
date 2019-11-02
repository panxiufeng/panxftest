
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