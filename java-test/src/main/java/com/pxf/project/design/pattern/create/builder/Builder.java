package com.pxf.project.design.pattern.create.builder;


import com.pxf.project.design.pattern.create.factory.demo1.*;

import java.util.ArrayList;
import java.util.List;


/**
 * 建造者模式（Builder）
 */
public class Builder {

    private List<Sender> list = new ArrayList<Sender>();

    public void produceMailSender(int count){
        for(int i=0; i<count; i++){
            list.add(new MailSender());
        }
    }

    public void produceSmsSender(int count){
        for(int i=0; i<count; i++){
            list.add(new SmsSender());
        }
    }


}
