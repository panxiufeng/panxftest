package com.pxf.project.design.pattern.struct.bridge;

public class MyBridge extends Bridge {
    public void method(){
        getSource().method();
    }
}
