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
package com.pxf.project.demo1;

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

        System.out.println("----->version 1");

    }
}