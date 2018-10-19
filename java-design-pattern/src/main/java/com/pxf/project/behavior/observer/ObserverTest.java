package com.pxf.project.behavior.observer;

/**
 * 观察者模式（Observer）
 *
 */
public class ObserverTest {

    public static void main(String[] args) {
        Subject sub = new MySubject();
        sub.add(new Observer1());
        sub.add(new Observer2());

        sub.operation();
    }
}
