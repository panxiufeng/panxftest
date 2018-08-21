package com.pxf.project.springboottest.fileupload.config;

import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.AbstractHttp11Protocol;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: TomcatConfig
 * @Description: TODO
 * @Author panxiufeng
 * @Date 2018/8/12下午12:31
 */
@Configuration
public class TomcatConfig {

    @Bean
    public ConfigurableServletWebServerFactory configurableServletWebServerFactory(){
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
//        factory.setPort(8089);//使用的是配置文件中的端口?
//        factory.addConnectorCustomizers(
//                connector -> {
//                    Http11NioProtocol protocol =
//                            (Http11NioProtocol) connector.getProtocolHandler();
//                    System.out.println("---------------------*************************____________________");
//                    protocol.setDisableUploadTimeout(false);
//                }
//        );

//        factory.addConnectorCustomizers(new GwsTomcatConnectionCustomizer());


        factory.addConnectorCustomizers((TomcatConnectorCustomizer) connector -> {
            if ((connector.getProtocolHandler() instanceof AbstractHttp11Protocol<?>)) {
                //-1 means unlimited
                ((AbstractHttp11Protocol<?>) connector.getProtocolHandler()).setMaxSwallowSize(-1);
            }
        });

        return factory;
    }


    @Value("${spring.server.port}")
    private Integer port;
    @Value("${spring.server.acceptorThreadCount}")
    private String acceptorThreadCount;
    @Value("${spring.server.minSpareThreads}")
    private String minSpareThreads;
    @Value("${spring.server.maxSpareThreads}")
    private String maxSpareThreads;
    @Value("${spring.server.maxThreads}")
    private String maxThreads;
    @Value("${spring.server.maxConnections}")
    private String maxConnections;
    @Value("${spring.server.protocol}")
    private String protocol;
    @Value("${spring.server.redirectPort}")
    private String redirectPort;
    @Value("${spring.server.compression}")
    private String compression;
    @Value("${spring.server.connectionTimeout}")
    private String connectionTimeout;

    @Value("${spring.server.MaxFileSize}")
    private String MaxFileSize;
    @Value("${spring.server.MaxRequestSize}")
    private String MaxRequestSize;


    /**
     *
     * 默认http连接
     *
     */
    public class GwsTomcatConnectionCustomizer implements TomcatConnectorCustomizer {

        public GwsTomcatConnectionCustomizer() {
        }

        @Override
        public void customize(Connector connector) {
            connector.setPort(port);
            connector.setAttribute("connectionTimeout", connectionTimeout);
            connector.setAttribute("acceptorThreadCount", acceptorThreadCount);
            connector.setAttribute("minSpareThreads", minSpareThreads);
            connector.setAttribute("maxSpareThreads", maxSpareThreads);
            connector.setAttribute("maxThreads", maxThreads);
            connector.setAttribute("maxConnections", maxConnections);
            connector.setAttribute("protocol", protocol);
            connector.setAttribute("redirectPort", "redirectPort");
            connector.setAttribute("compression", "compression");
        }
    }


}
