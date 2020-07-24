package com.pxf.project.jdk8;

import java.util.Comparator;
import java.util.TreeSet;

public class LambdaTest {

    public static void main(String[] args) {

        //1.
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("----->running....");
            }
        };
        new Thread(runnable).start();

        Runnable runnable2 =  ()->{System.out.println("----->lambda running...");};
        new Thread(runnable2).start();

        new Thread(()->System.out.println("----->lambda running2...")).start();

        //2.
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        };
        TreeSet<String> treeSet = new TreeSet<String>(comparator);

        Comparator<String> comparator2 = (o1,o2)->o1.length()-o2.length();
        TreeSet treeSet2 = new TreeSet<String>(comparator2);

        TreeSet treeSet3 = new TreeSet<String>((o1,o2)->o1.length()-o2.length());

    }
}
