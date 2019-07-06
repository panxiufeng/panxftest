
package com.pxf.project.zz;

/**
 *   验证属性加载顺序
 * @author panxiufeng
 * @version Id: LoadOrder.java, v 0.1 2019/3/7 19:43 panxiufeng Exp $$
 */
public class LoadOrder {

    // 静态属性
    private static String staticField = getStaticField();
    // 静态方法块
    static {
        System.out.println("LoadOrder静态方法块初始化");
        System.out.println("---------------------------------");
    }
    // 普通属性
    private String field = getField();
    // 普通方法块
    {
        System.out.println("LoadOrder普通方法块初始化");
        System.out.println("---------------------------------");
    }
    // 构造函数
    public LoadOrder() {
        System.out.println("LoadOrder构造函数初始化");
        System.out.println("---------------------------------");
    }

    public static String getStaticField() {
        String statiFiled = "Static Field Initial";
        System.out.println("LoadOrder静态属性初始化");
        System.out.println("---------------------------------");
        return statiFiled;
    }

    public static String getField() {
        String filed = "Field Initial";
        System.out.println("LoadOrder普通属性初始化");
        System.out.println("---------------------------------");
        return filed;
    }
    // 主函数
    public static void main(String[] argc) {
        System.out.println("LoadOrder main方法");
        System.out.println("---------------------------------");
        new LoadOrder();
    }
}