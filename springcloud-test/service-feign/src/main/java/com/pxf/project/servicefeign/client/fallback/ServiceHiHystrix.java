package com.pxf.project.servicefeign.client.fallback;

import com.pxf.project.servicefeign.client.ServiceHiClient;
import org.springframework.stereotype.Component;

@Component
public class ServiceHiHystrix  implements ServiceHiClient {


    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry, you are fail,"+name;
    }

}
