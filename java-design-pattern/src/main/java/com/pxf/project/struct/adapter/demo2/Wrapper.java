package com.pxf.project.struct.adapter.demo2;

import com.pxf.project.struct.adapter.demo1.Source;
import com.pxf.project.struct.adapter.demo1.Targetable;

public class Wrapper  implements Targetable {

    private Source source;

    public Wrapper(Source source){
        super();
        this.source = source;
    }

    @Override
    public void method2() {
        System.out.println("this is the targetable method!");
    }

    @Override
    public void method1() {
        source.method1();
    }
}
