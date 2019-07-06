
package com.pxf.project.design.pattern.behavior.state;

/**
 *
 * @author panxiufeng
 * @version Id: Context.java, v 0.1 2018/10/23 14:30 panxiufeng Exp $$
 */
public class Context {

    private State state;

    public Context(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void method() {
        if (state.getValue().equals("state1")) {
            state.method1();
        } else if (state.getValue().equals("state2")) {
            state.method2();
        }
    }

}