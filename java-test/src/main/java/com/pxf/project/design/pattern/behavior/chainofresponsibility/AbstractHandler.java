
package com.pxf.project.design.pattern.behavior.chainofresponsibility;

/**
 *
 * @author panxiufeng
 * @version Id: AbstractHandler.java, v 0.1 2018/10/23 13:55 panxiufeng Exp $$
 */
public abstract class AbstractHandler  {

    private Handler handler;

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

}