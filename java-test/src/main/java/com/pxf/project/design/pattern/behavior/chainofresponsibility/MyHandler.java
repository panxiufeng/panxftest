
package com.pxf.project.design.pattern.behavior.chainofresponsibility;

/**
 *
 * @author panxiufeng
 * @version Id: MyHandler.java, v 0.1 2018/10/23 13:56 panxiufeng Exp $$
 */
public class MyHandler extends AbstractHandler implements Handler {

    private String name;

    public MyHandler(String name) {
        this.name = name;
    }

    @Override
    public void operator() {
        System.out.println(name+"  deal!");
        if(getHandler()!=null){
            getHandler().operator();
        }
    }
}