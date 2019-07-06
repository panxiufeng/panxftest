
package com.pxf.project.design.pattern.behavior.visitor;

/**
 *
 * @author panxiufeng
 * @version Id: MyVisitor.java, v 0.1 2018/10/23 14:34 panxiufeng Exp $$
 */
public class MyVisitor implements Visitor {


    @Override
    public void visit(com.pxf.project.design.pattern.behavior.visitor.Subject sub) {
        System.out.println("visit the subject："+sub.getSubject());
    }
}