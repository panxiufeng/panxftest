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
 *
 * @author panxiufeng
 * @version Id: LoadOrderSon.java, v 0.1 2019/3/7 19:49 panxiufeng Exp $$
 */
public class LoadOrderSon extends LoadOrder {

    // 静态属性
    private static String staticField = getStaticField();
    // 静态方法块
    static {
        System.out.println("LoadOrderSon静态方法块初始化");
        System.out.println("---------------------------------");
    }
    // 普通属性
    private String field = getField();
    // 普通方法块
    {
        System.out.println("LoadOrderSon普通方法块初始化");
        System.out.println("---------------------------------");
    }
    // 构造函数
    public LoadOrderSon() {
        System.out.println("LoadOrder构造函数初始化");
        System.out.println("---------------------------------");
    }

    public static String getStaticField() {
        String statiFiled = "Static Field Initial";
        System.out.println("LoadOrderSon静态属性初始化");
        System.out.println("---------------------------------");
        return statiFiled;
    }

    public static String getField() {
        String filed = "Field Initial";
        System.out.println("LoadOrderSon普通属性初始化");
        System.out.println("---------------------------------");
        return filed;
    }
    // 主函数
    public static void main(String[] argc) {
        System.out.println("LoadOrderSon main方法");
        System.out.println("---------------------------------");
        new LoadOrderSon();
    }

}