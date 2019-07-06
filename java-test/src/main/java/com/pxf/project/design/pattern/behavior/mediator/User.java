
package com.pxf.project.design.pattern.behavior.mediator;

/**
 *
 * @author panxiufeng
 * @version Id: User.java, v 0.1 2018/10/23 14:42 panxiufeng Exp $$
 */
public abstract  class User {


    private Mediator mediator;

    public Mediator getMediator(){
        return mediator;
    }

    public User(Mediator mediator) {
        this.mediator = mediator;
    }

    public abstract void work();
}