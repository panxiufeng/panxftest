package com.pxf.project.create.factory.demo1;

public class SmsSender implements Sender {
    @Override
    public void send() {
        System.out.println("----->SmsSender send ");
    }
}
