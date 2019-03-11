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
package com.pxf.project.design.pattern.behavior.state;

/**
 *
 * @author panxiufeng
 * @version Id: Test.java, v 0.1 2018/10/23 14:30 panxiufeng Exp $$
 */
public class Test {


    /**
     * 状态模式（State）
         核心思想就是：当对象的状态改变时，同时改变其行为，很好理解！
         就拿QQ来说，有几种状态，在线、隐身、忙碌等，每个状态对应不同的操作，
         而且你的好友也能看到你的状态，
         所以，状态模式就两点：
         1、可以通过改变状态来获得不同的行为。
         2、你的好友能同时看到你的变化


     *根据这个特性，状态模式在日常开发中用的挺多的，
     * 尤其是做网站的时候，我们有时希望根据对象的某一属性，
     * 区别开他们的一些功能，比如说简单的权限控制等
     */
    public static void main(String[] args) {

        State state = new State();
        Context context = new Context(state);

        //设置第一种状态
        state.setValue("state1");
        context.method();

        //设置第二种状态
        state.setValue("state2");
        context.method();
    }
}