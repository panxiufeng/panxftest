package com.pxf.project.create.factory.demo2;

public class SendSmsFactory  implements Provider{
    @Override
    public Sender produce() {
        return new SmsSender();
    }
}
