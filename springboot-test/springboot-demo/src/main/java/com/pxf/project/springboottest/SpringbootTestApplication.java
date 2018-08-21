package com.pxf.project.springboottest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//开启定时任务
@EnableScheduling
//public class SpringbootTestApplication extends SpringBootServletInitializer {   //打war包
public class SpringbootTestApplication{
	public static void main(String[] args) {
		SpringApplication.run(SpringbootTestApplication.class, args);
	}


//	//打war包   pom.xml 文件，将 jar 改成 war
//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//		return application.sources(SpringbootTestApplication.class);
//	}

}

