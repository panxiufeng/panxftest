
package com.pxf.project.thread;

/**
 *
 * @author panxiufeng
 * @version Id: MyThread1.java, v 0.1 2018/12/28 10:59 panxiufeng Exp $$
 */
public class MyThread1 extends Thread {
    
    private int count = 5;

    private String str;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public MyThread1(){
        super();
    }
    public MyThread1(String name){
        super();
        this.setName(name);
    }
    //1
//    @Override
//    public void run() {
//        super.run();
//        while (count>0){
//            count--;
//            System.out.println(Thread.currentThread().getName()+"------>count:"+count+"--->str:"+str);
//        }
//    }

    //2
//    @Override
//    public void run() {
//        super.run();
//        count--;
//        System.out.println(Thread.currentThread().getName()+"------>count:"+count+"--->str:"+str);
//    }

    //3
//    @Override
//    public synchronized void run() {
//        super.run();
//        count--;
//        System.out.println(Thread.currentThread().getName()+"------>count:"+count);
//    }

    //4
    @Override
    public  void run() {
        PublicPart.doSomething(str,str);
    }


}