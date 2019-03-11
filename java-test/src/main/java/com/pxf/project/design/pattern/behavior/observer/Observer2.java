package com.pxf.project.design.pattern.behavior.observer;

public class Observer2 implements Observer {
    @Override
    public void update() {
        System.out.println("observer2 has received!");
    }
}
