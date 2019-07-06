
package com.pxf.project.design.pattern.behavior.memento;

/**
 *
 * @author panxiufeng
 * @version Id: Memento.java, v 0.1 2018/10/23 14:24 panxiufeng Exp $$
 */
public class Memento {

    private String value;

    public Memento(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}