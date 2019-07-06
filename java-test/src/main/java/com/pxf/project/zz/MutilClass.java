
package com.pxf.project.zz;

/**
 *  内部类编译生成几个文件？？？
 * @author panxiufeng
 * @version Id: MutilClass.java, v 0.1 2019/3/7 20:33 panxiufeng Exp $$
 */
public class MutilClass {

    private void display() {
        new B().show();
    }

    public static void main(String[] args) {
        System.out.println("==========");
        new MutilClass().display();
    }

    class B{
        public void show(){
            System.out.println("-----show------------");
        }
    }

    class C{}

    private class D{}
}

