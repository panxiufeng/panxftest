
package com.pxf.project.zz;

/**
 *
 * @author panxiufeng
 * @version Id: LoadOrderSon.java, v 0.1 2019/3/7 19:49 panxiufeng Exp $$
 */
public class LoadOrderSon extends LoadOrder {

    // 静态属性
    private static String staticField = getStaticField();
    // 静态方法块
    static {
        System.out.println("LoadOrderSon静态方法块初始化");
        System.out.println("---------------------------------");
    }
    // 普通属性
    private String field = getField();
    // 普通方法块
    {
        System.out.println("LoadOrderSon普通方法块初始化");
        System.out.println("---------------------------------");
    }
    // 构造函数
    public LoadOrderSon() {
        System.out.println("LoadOrder构造函数初始化");
        System.out.println("---------------------------------");
    }

    public static String getStaticField() {
        String statiFiled = "Static Field Initial";
        System.out.println("LoadOrderSon静态属性初始化");
        System.out.println("---------------------------------");
        return statiFiled;
    }

    public static String getField() {
        String filed = "Field Initial";
        System.out.println("LoadOrderSon普通属性初始化");
        System.out.println("---------------------------------");
        return filed;
    }
    // 主函数
    public static void main(String[] argc) {
        System.out.println("LoadOrderSon main方法");
        System.out.println("---------------------------------");
        new LoadOrderSon();
    }

}