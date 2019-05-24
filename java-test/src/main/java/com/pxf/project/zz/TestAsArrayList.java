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

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author panxiufeng
 * @version Id: TestAsArrayList.java, v 0.1 2019/5/23 10:03 panxiufeng Exp $$
 */
public class TestAsArrayList {
    
    public static void main(String[] args) {
        int  h = 131075;
//        int code = "key2".hashCode();
//        System.out.println("code="+code);
//        System.out.println( code ^ (code>>>16));

//        System.out.println( 35 & (16-1));
//        System.out.println(35 % 16);
        int x = 6;
        System.out.println(31*x == (x<<5)-x);

//        http://wiki.jikexueyuan.com/project/java-enhancement/java-thirtysix.html
        int[] ints = {1,2,3,4,5};
        List list = Arrays.asList(ints);  // List<ints[]>
        System.out.println("list'size：" + list.size());


        Integer[] ints2 = {1,2,3,4,5};
        List list2 = Arrays.asList(ints2);  //List<Integer>
        System.out.println("list2'size：" + list2.size());


    }

}