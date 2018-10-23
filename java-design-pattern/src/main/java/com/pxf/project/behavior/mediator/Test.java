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
package com.pxf.project.behavior.mediator;

/**
 *
 * @author panxiufeng
 * @version Id: Test.java, v 0.1 2018/10/23 14:44 panxiufeng Exp $$
 */
public class Test {

    /**
     * 中介者模式（Mediator）
         中介者模式也是用来降低类类之间的耦合的，因为如果类类之间有依赖关系的话，
         不利于功能的拓展和维护，因为只要修改一个对象，其它关联的对象都得进行修改。
         如果使用中介者模式，只需关心和Mediator类的关系，
         具体类类之间的关系及调度交给Mediator就行，这有点像spring容器的作用。

     */
    public static void main(String[] args) {
        Mediator mediator = new MyMediator();
        mediator.createMediator();
        mediator.workAll();
    }
}