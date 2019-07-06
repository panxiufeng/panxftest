
package com.pxf.project.springboottest.common.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 *
 * @author panxiufeng
 * @version Id: TestModel.java, v 0.1 2019/2/26 15:04 panxiufeng Exp $$
 */

@Configuration
@ConfigurationProperties(prefix = "com.dudu")
@PropertySource("classpath:test.properties")
public class TestModel {

    private String name;
    private String want;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWant() {
        return want;
    }

    public void setWant(String want) {
        this.want = want;
    }
}