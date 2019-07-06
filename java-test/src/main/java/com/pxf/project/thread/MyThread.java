
package com.pxf.project.thread;

/**
 *
 * @author panxiufeng
 * @version Id: MyThread.java, v 0.1 2019/4/15 15:21 panxiufeng Exp $$
 */
public class MyThread implements Runnable{

    private  String str;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    @Override
    public void run() {

        Test t = new Test();
        t.test(str);
    }

}