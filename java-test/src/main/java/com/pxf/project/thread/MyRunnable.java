
package com.pxf.project.thread;

/**
 *
 * @author panxiufeng
 * @version Id: MyRunnable.java, v 0.1 2019/3/16 17:49 panxiufeng Exp $$
 */
public class MyRunnable implements Runnable {

    String aa = "11111111111111";
    @Override
    public void run() {
        System.out.println("----->"+aa);
    }
}