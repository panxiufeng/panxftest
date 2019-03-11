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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 *
 * @author panxiufeng
 * @version Id: MyObject.java, v 0.1 2019/2/28 14:07 panxiufeng Exp $$
 */
public class MyObject extends Object {

    public static void main(String[] args) {
        String str ="aa";
        str = new String("qqqqqqq");
        System.out.println("str="+str);


        String [] arr = new String[]{"1b","2b","3b","4b"};

        String [] arr2 = {"1","2","3"};

        // list

        ArrayList<String> list = new ArrayList<String>(Arrays.asList("o1", "o2"));

        List<String> list2 = Arrays.asList("1a","2a");
//        list2 = Arrays.asList(arr2);

        arr2 = list2.toArray(arr2);

        list2 = new ArrayList();
        list2.add("1c");
        list2.add("2c");
        list2.addAll(list);

        ArrayList<String> list3 = new ArrayList<String>() {
            {
                add("1");
                add("2");
            }
        };



        //subString
        String [] arr4 = new String[]{"1b","2b","3b","4b","5b","6b","7b"};
        List<String> list4 = Arrays.asList(arr4);
        System.out.println("list4="+list4);
        List<String> list5 = list4.subList(2,4);
        System.out.println("list5="+list5);
        list5.set(0,"qqqqqqqqqqq");
        System.out.println("list5="+list5);
        System.out.println("list4="+list4);

        //lambda
        List<Integer> numbers = new ArrayList<>();
        //no.1
        numbers.forEach((Integer integer) -> {
            System.out.println(integer);
        });

        //no.2
        numbers.forEach(integer -> {
            System.out.println(integer);
        });

        //no.3
        numbers.forEach(integer -> System.out.println(integer));

        //no.4
        numbers.forEach(System.out::println);

        //no.5
        numbers.forEach(new MyConsumer());



        String sw = "";
        switch (sw){
            case "1":
                System.out.println("1");
                break;
            case "2":
                System.out.println("2");
                break;
            case "3":
                System.out.println("1");
                break;
            default:
                System.out.println("default");
                break;
        }



    }
}

class MyConsumer implements Consumer<Integer> {

    @Override
    public void accept(Integer integer) {
        System.out.println(integer);
    }
}