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
 * @version Id: TestInteger.java, v 0.1 2019/5/22 13:58 panxiufeng Exp $$
 */
public class TestInteger {

    public static void main(String[] args) {
        Integer a = new Integer(88);
        Integer b = new Integer(88);
        System.out.println(a == b);


        Integer c = new Integer(88888);
        Integer d = new Integer(88888);

        System.out.println( c == d);

        Integer e = 55;
        Integer f = new Integer(55);
        System.out.println(e == f);
        System.out.println(55 == f);

        System.out.println("-----------------------------");

        Integer g = 88;
        Integer h = 88;
        Integer h2 = Integer.valueOf(88);
        System.out.println(g == h );
        System.out.println(g == h2 );

        Integer i = 8888;
        Integer j = 8888;
        System.out.println(i == j );


    }

}