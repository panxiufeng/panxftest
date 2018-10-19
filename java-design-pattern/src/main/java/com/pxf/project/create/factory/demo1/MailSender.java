package com.pxf.project.create.factory.demo1;

public class MailSender implements Sender {
    @Override
    public void send() {
        System.out.println("----->MailSender send ");
    }
}
