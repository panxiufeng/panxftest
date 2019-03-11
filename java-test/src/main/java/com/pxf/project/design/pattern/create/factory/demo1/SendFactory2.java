package com.pxf.project.design.pattern.create.factory.demo1;

/**
 * 多个工厂方法模式
 */
public class SendFactory2 {
    
    public Sender produceMail(){
        return new MailSender();
    }

    public Sender produceSms(){
        return new SmsSender();
    }

    
    public static void main(String[] args) {
        SendFactory2 factory = new SendFactory2();
        Sender sender = factory.produceMail();
        sender.send();

        sender = factory.produceSms();
        sender.send();

    }
}
