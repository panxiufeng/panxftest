package com.pxf.project.struct.adapter.demo1;

public class Adapter  extends Source implements Targetable {
    @Override
    public void method2() {
        System.out.println("this is the targetable method!");
    }
}
