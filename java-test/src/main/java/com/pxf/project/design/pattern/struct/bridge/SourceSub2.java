package com.pxf.project.design.pattern.struct.bridge;

public class SourceSub2 implements Sourceable {
    @Override
    public void method() {
        System.out.println("this is the second sub!");
    }
}
