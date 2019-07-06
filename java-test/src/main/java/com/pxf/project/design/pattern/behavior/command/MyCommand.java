
package com.pxf.project.design.pattern.behavior.command;

/**
 *
 * @author panxiufeng
 * @version Id: MyCommand.java, v 0.1 2018/10/23 14:03 panxiufeng Exp $$
 */
public class MyCommand implements Command {

    private Receiver receiver;

    public MyCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void exe() {
        receiver.action();
    }
}