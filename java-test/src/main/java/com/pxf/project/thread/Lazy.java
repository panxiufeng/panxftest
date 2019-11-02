
package com.pxf.project.thread;

/**
 *
 * @author panxiufeng
 * @version Id: Lazy.java, v 0.1 2019/7/18 14:38 panxiufeng Exp $$
 */
public class Lazy {

    private static boolean initialized = false;

    static {
        Thread t = new Thread(() -> initialized = true);
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