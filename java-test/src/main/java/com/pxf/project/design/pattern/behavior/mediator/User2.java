
package com.pxf.project.design.pattern.behavior.mediator;

/**
 *
 * @author panxiufeng
 * @version Id: User2.java, v 0.1 2018/10/23 14:43 panxiufeng Exp $$
 */
public class User2 extends User {

    public User2(Mediator mediator){
        super(mediator);
    }

    @Override
    public void work() {
        System.out.println("user2 exe!");
    }
}