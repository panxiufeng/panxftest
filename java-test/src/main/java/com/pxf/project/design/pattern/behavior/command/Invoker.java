
package com.pxf.project.design.pattern.behavior.command;

/**
 *
 * @author panxiufeng
 * @version Id: Invoker.java, v 0.1 2018/10/23 14:04 panxiufeng Exp $$
 */
public class Invoker {

    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void action(){
        command.exe();
    }
}