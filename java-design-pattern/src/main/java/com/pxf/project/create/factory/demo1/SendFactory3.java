package com.pxf.project.create.factory.demo1;

/**
 * 静态工厂方法模式
 */
public class SendFactory3 {
    
    public static Sender produceMail(){
        return new MailSender();
    }

    public static Sender produceSms(){
        return new SmsSender();
    }

    
    public static void main(String[] args) {
        Sender sender = SendFactory3.produceMail();
        sender.send();

        sender = SendFactory3.produceSms();
        sender.send();

    }
}
