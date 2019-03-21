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
package com.pxf.project.zz;

/**
 *  内部类编译生成几个文件？？？
 * @author panxiufeng
 * @version Id: MutilClass.java, v 0.1 2019/3/7 20:33 panxiufeng Exp $$
 */
public class MutilClass {

    private void display() {
        new B().show();
    }

    public static void main(String[] args) {
        System.out.println("==========");
        new MutilClass().display();
    }

    class B{
        public void show(){
            System.out.println("-----show------------");
        }
    }

    class C{}

    private class D{}
}

