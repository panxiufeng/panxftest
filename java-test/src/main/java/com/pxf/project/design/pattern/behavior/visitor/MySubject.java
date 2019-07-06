
package com.pxf.project.design.pattern.behavior.visitor;

/**
 *
 * @author panxiufeng
 * @version Id: MySubject.java, v 0.1 2018/10/23 14:36 panxiufeng Exp $$
 */
public class MySubject implements Subject {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String getSubject() {
        return "love";
    }

}