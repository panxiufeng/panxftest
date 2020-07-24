package com.pxf.project.statictest;

public class Parent {

//    private static Parent parent =new Parent(); //父类静态变量
    static{
        System.out.println("父类静态代码块");
    }
    {
        System.out.println("父类普通代码块");
    }
    public Parent(){
        System.out.println("父类构造方法");
    }
}
