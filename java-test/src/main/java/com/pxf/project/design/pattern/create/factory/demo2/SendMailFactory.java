package com.pxf.project.design.pattern.create.factory.demo2;

public class SendMailFactory  implements Provider{
    @Override
    public Sender produce() {
        return new MailSender();
    }
}
