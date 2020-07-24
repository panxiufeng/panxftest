package com.pxf.project.statictest;

public class Sub extends Parent{

//    private static Sub sub = new Sub(); //子类静态变量
    static{
        System.out.println("子类静态代码块");
    }
    {
        System.out.println("子类普通代码块");
    }
    public Sub(){
        System.out.println("子类构造方法");
    }


}
