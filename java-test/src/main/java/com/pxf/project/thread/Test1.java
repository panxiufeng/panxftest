
package com.pxf.project.thread;

/**
 *
 * @author panxiufeng
 * @version Id: Test1.java, v 0.1 2018/12/28 11:05 panxiufeng Exp $$
 */
public class Test1 {

    public static void main(String[] args) {

        //1
//        MyThread1 ta = new       MyThread1("A");
//        ta.setStr("TA");
//        MyThread1 tb = new       MyThread1("B");
//        tb.setStr("TB");
//        ta.start();
//        tb.start();

        //2
//        for(int i=0;i<5;i++){
//            MyThread1 t = new       MyThread1("T"+i);
//            t.setStr("T"+i);
//            t.start();
//        }

        //3
//        MyThread1 mt = new       MyThread1();
//        for(int i=0;i<5;i++){
//            Thread t = new       Thread(mt,"T"+i);
//            t.start();
//        }

        //4
        for(int i=0;i<5;i++){
            MyThread1 t = new       MyThread1("T"+i);
            t.setStr("T"+i);
            t.start();
        }

        System.out.println("----->强制回退 version 1");  //测试git使用

    }
}