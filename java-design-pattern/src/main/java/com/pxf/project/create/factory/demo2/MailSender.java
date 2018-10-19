package com.pxf.project.create.factory.demo2;

/**
 * 工厂方法模式（Factory Method）
 */
public class MailSender implements Sender {
    @Override
    public void send() {
        System.out.println("----->MailSender send ");
    }
}
