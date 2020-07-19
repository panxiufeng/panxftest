package com.pxf.project.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ThreadLocalTest {

    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {

        threadLocal.set("A");
        threadLocal.set("B");

        Map<String,String> map = new HashMap<String,String>();
        map.put("AA","AA");
        map.put("BB","BB");

        ConcurrentHashMap<String,String> concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put("AA","AA");


    }
}
