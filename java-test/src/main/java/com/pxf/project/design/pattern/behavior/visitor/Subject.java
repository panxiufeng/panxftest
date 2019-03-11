
package com.pxf.project.design.pattern.behavior.visitor;

public interface  Subject {

    public void accept(Visitor visitor);
    public String getSubject();
}