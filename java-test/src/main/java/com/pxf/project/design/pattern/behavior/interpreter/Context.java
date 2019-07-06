
package com.pxf.project.design.pattern.behavior.interpreter;

/**
 *
 * @author panxiufeng
 * @version Id: Context.java, v 0.1 2018/10/23 14:45 panxiufeng Exp $$
 */
public class Context {


    private int num1;
    private int num2;

    public Context(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public int getNum1() {
        return num1;
    }
    public void setNum1(int num1) {
        this.num1 = num1;
    }
    public int getNum2() {
        return num2;
    }
    public void setNum2(int num2) {
        this.num2 = num2;
    }

}