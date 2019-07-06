
package com.pxf.project.design.pattern.behavior.state;

/**
 *
 * @author panxiufeng
 * @version Id: State.java, v 0.1 2018/10/23 14:30 panxiufeng Exp $$
 */
public class State {

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void method1(){
        System.out.println("execute the first opt!");
    }

    public void method2(){
        System.out.println("execute the second opt!");
    }
}