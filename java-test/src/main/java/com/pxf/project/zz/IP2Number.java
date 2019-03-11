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
 * @version Id: IP2Number.java, v 0.1 2019/3/7 11:09 panxiufeng Exp $$
 */
public class IP2Number {


    public static int ip2Int (String ipStr){

        String[] ipSlices = ipStr.split("\\.");
        int result = 0;
        for(int i=0;i<ipSlices.length;i++){
            int intSlice = Integer.parseInt(ipSlices[i]) << (8 * i);
            result = result | intSlice;
        }
        return result;
    }


    public static String int2Ip (int ipInt){

        String[] ipStr  = new String[4];
        for(int i=0;i<4;i++){
           int position = i * 8;
           int _and = ipInt & (255 << position);
            ipStr[i] = String.valueOf(_and >>> position);
        }
        return String.join(".",ipStr);
    }

    public static void main(String[] args) {

        String ipStr = "192.168.1.246";
        int ip = ip2Int(ipStr);
        System.out.println("ip----->"+ip);
        System.out.println("ip二进制----->"+Long.toBinaryString(ip));

        String ipStr1 = int2Ip(ip);
        System.out.println("int2Ip----->"+ipStr1);


        int a1 = -6;
        int a2 = 3;
        System.out.println(a1|a2);
    }
    
}