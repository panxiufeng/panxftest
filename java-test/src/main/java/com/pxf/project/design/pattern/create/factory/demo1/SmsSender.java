package com.pxf.project.design.pattern.create.factory.demo1;

public class SmsSender implements Sender {
    @Override
    public void send() {
        System.out.println("----->SmsSender send ");
    }
}
