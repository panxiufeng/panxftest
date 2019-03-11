package com.pxf.project.design.pattern.create.factory.demo2;

public class SmsSender implements Sender {
    @Override
    public void send() {
        System.out.println("----->SmsSender send ");
    }
}
