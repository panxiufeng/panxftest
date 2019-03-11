package com.pxf.project.design.pattern.create.factory.demo2;

public class SendSmsFactory  implements Provider{
    @Override
    public Sender produce() {
        return new SmsSender();
    }
}
