
package com.pxf.project.design.pattern.behavior.memento;

/**
 *
 * @author panxiufeng
 * @version Id: Storage.java, v 0.1 2018/10/23 14:24 panxiufeng Exp $$
 */
public class Storage {

    private Memento memento;

    public Storage(Memento memento) {
        this.memento = memento;
    }

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}