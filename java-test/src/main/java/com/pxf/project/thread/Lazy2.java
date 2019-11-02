
package com.pxf.project.thread;

/**
 *
 * @author panxiufeng
 * @version Id: Lazy2.java, v 0.1 2019/7/18 14:43 panxiufeng Exp $$
 */
public class Lazy2 {

    private static boolean initialized = false;

    static {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                initialized = true;
            }
        });
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            throw new AssertionError(e);
        }
    }

    public static void main(String[] args) {
        System.out.println(initialized);
    }
}