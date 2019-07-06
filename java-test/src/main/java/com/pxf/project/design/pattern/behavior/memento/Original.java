
package com.pxf.project.design.pattern.behavior.memento;

/**
 *
 * @author panxiufeng
 * @version Id: Original.java, v 0.1 2018/10/23 14:23 panxiufeng Exp $$
 */
public class Original {

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Original(String value) {
        this.value = value;
    }

    public Memento createMemento(){
        return new Memento(value);
    }

    public void restoreMemento(Memento memento){
        this.value = memento.getValue();
    }
}