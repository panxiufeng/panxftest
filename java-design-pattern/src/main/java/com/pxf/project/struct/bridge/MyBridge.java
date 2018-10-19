package com.pxf.project.struct.bridge;

public class MyBridge extends Bridge {
    public void method(){
        getSource().method();
    }
}
