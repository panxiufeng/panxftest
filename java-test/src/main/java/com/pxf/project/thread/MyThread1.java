/**
 * Software License Declaration.
 * <p>
 * wandaph.com, Co,. Ltd.
 * Copyright ? 2017 All Rights Reserved.
 * <p>
 * Copyright Notice
 * This documents is provided to wandaph contracting agent or authorized programmer only.
 * This source code is written and edited by wandaph Co,.Ltd Inc specially for financial
 * business contracting agent or authorized cooperative company, in order to help them to
 * install, programme or central control in certain project by themselves independently.
 * <p>
 * Disclaimer
 * If this source code is needed by the one neither contracting agent nor authorized programmer
 * during the use of the code, should contact to wandaph Co,. Ltd Inc, and get the confirmation
 * and agreement of three departments managers  - Research Department, Marketing Department and
 * Production Department.Otherwise wandaph will charge the fee according to the programme itself.
 * <p>
 * Any one,including contracting agent and authorized programmer,cannot share this code to
 * the third party without the agreement of wandaph. If Any problem cannot be solved in the
 * procedure of programming should be feedback to wandaph Co,. Ltd Inc in time, Thank you!
 */
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