
package com.pxf.project.design.pattern.behavior.interpreter;

/**
 *
 * @author panxiufeng
 * @version Id: Test.java, v 0.1 2018/10/23 14:46 panxiufeng Exp $$
 */
public class Test {

    /**
     * 解释器模式一般主要应用在OOP开发中的编译器的开发中，所以适用面比较窄
     *
     * Context类是一个上下文环境类，Plus和Minus分别是用来计算的实现
     * 基本就这样，解释器模式用来做各种各样的解释器，如正则表达式等的解释器等等
     * @
     */
    public static void main(String[] args) {

        // 计算9+2-8的值
        int result = new Minus().interpret((new Context(new Plus()
                .interpret(new Context(9, 2)), 8)));
        System.out.println(result);
    }
}