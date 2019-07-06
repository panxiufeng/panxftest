
package com.pxf.project.design.pattern.behavior.mediator;

/**
 *
 * @author panxiufeng
 * @version Id: User1.java, v 0.1 2018/10/23 14:43 panxiufeng Exp $$
 */
public class User1 extends User {

    public User1(Mediator mediator){
        super(mediator);
    }

    @Override
    public void work() {
        System.out.println("user1 exe!");
    }

}