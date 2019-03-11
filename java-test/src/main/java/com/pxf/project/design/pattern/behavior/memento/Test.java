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
package com.pxf.project.design.pattern.behavior.memento;

/**
 *
 * @author panxiufeng
 * @version Id: Test.java, v 0.1 2018/10/23 14:24 panxiufeng Exp $$
 */
public class Test {

    /**
     *
     * 备忘录模式（Memento）
         主要目的是保存一个对象的某个状态，以便在适当的时候恢复对象，个人觉得叫备份模式更形象些，
         通俗的讲下：假设有原始类A，A中有各种属性，A可以决定需要备份的属性备忘录类B是用来存储A的一些内部状态，类C呢，
         就是一个用来存储备忘录的，且只能存储，不能修改等操作。

     * Original类是原始类，里面有需要保存的属性value及创建一个备忘录类，用来保存value值。
     * Memento类是备忘录类，Storage类是存储备忘录的类，持有Memento类的实例，该模式很好理解。
     *
     */
    public static void main(String[] args) {

        // 创建原始类
        Original origi = new Original("egg");

        // 创建备忘录
        Storage storage = new Storage(origi.createMemento());

        // 修改原始类的状态
        System.out.println("初始化状态为：" + origi.getValue());
        origi.setValue("niu");
        System.out.println("修改后的状态为：" + origi.getValue());

        // 回复原始类的状态
        origi.restoreMemento(storage.getMemento());
        System.out.println("恢复后的状态为：" + origi.getValue());
    }
}