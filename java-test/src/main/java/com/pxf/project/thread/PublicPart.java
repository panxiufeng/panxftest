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

/**
 *
 * @author panxiufeng
 * @version Id: PublicPart.java, v 0.1 2018/12/28 13:58 panxiufeng Exp $$
 */
public class PublicPart {

    private static String userName ;
    private static String userPwd ;


//    public static synchronized  void doSomething(String user_name,String user_pwd){
    public static void doSomething(String user_name,String user_pwd){

        try {
            userName = user_name;
            if(user_name.endsWith("2")){
                Thread.sleep(5000);
            }
            userPwd = user_pwd;
            System.out.println("userName="+userName+" ; userPwd="+userPwd+"      "+Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}