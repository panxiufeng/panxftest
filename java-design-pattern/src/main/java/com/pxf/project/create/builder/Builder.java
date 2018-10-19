package com.pxf.project.create.builder;

import com.pxf.project.create.factory.demo1.Sender;
import com.pxf.project.create.factory.demo1.SmsSender;
import com.pxf.project.create.factory.demo1.MailSender;

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
