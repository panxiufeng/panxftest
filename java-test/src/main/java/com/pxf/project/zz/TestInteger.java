
package com.pxf.project.zz;

/**
 *
 * @author panxiufeng
 * @version Id: TestInteger.java, v 0.1 2019/5/22 13:58 panxiufeng Exp $$
 */
public class TestInteger {

    public static void main(String[] args) {
        Integer a = new Integer(88);
        Integer b = new Integer(88);
        System.out.println(a == b);


        Integer c = new Integer(88888);
        Integer d = new Integer(88888);

        System.out.println( c == d);

        Integer e = 55;
        Integer f = new Integer(55);
        System.out.println(e == f);
        System.out.println(55 == f);

        System.out.println("-----------------------------");

        Integer g = 88;
        Integer h = 88;
        Integer h2 = Integer.valueOf(88);
        System.out.println(g == h );
        System.out.println(g == h2 );

        Integer i = 8888;
        Integer j = 8888;
        System.out.println(i == j );


    }

}