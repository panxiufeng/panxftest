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

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author panxiufeng
 * @version Id: Test.java, v 0.1 2019/4/15 15:20 panxiufeng Exp $$
 */
public class Test {

    public static void main(String[] args) {
        ExecutorService singleThreadPool = Executors.newSingleThreadExecutor();
//        MyThread t1 = new MyThread();
//        t1.setStr("aaaa");
//        MyThread t2 = new MyThread();
//        t2.setStr("bbbb");
//        singleThreadPool.execute(t1);
//        singleThreadPool.execute(t2);

//        singleThreadPool.submit(t1);
//        singleThreadPool.submit(t2);
//        singleThreadPool.shutdown();

        MyThread t3 = null;
        for(int i=0;i<=100;i++){
            t3 = new MyThread();
            t3.setStr("MyThread---"+i);
            singleThreadPool.execute(t3);
        }
        System.out.println("isShutdown=============================================="+singleThreadPool.isShutdown());
//        singleThreadPool.shutdown();
//        System.out.println("isTerminated=============================================="+singleThreadPool.isTerminated());
//        System.out.println("isShutdown=============================================="+singleThreadPool.isShutdown());

        try {
            Thread.sleep(30000);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        singleThreadPool.shutdown();
        System.out.println("isShutdown=============================================="+singleThreadPool.isShutdown());

        MyThread t4 = new MyThread();
        Thread thread = new Thread(t4);
        thread.setPriority(9);

    }

    public void test(String str){
        for(int i=0;i<=100;i++){
            System.out.println(Thread.currentThread().getName()+":"+str+":"+i);
        }
    }
}