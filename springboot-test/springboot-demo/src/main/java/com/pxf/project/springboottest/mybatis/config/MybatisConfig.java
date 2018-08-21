package com.pxf.project.springboottest.mybatis.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.pxf.project.springboottest.mybatis.mapper")
public class MybatisConfig {
}
