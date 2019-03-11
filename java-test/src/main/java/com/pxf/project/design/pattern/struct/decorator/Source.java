package com.pxf.project.design.pattern.struct.decorator;

public class Source  implements Sourceable {
    @Override
    public void method() {
        System.out.println("the original method!");
    }
}
