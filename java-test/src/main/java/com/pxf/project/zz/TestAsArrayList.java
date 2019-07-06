
package com.pxf.project.zz;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author panxiufeng
 * @version Id: TestAsArrayList.java, v 0.1 2019/5/23 10:03 panxiufeng Exp $$
 */
public class TestAsArrayList {
    
    public static void main(String[] args) {
        int  h = 131075;
//        int code = "key2".hashCode();
//        System.out.println("code="+code);
//        System.out.println( code ^ (code>>>16));

//        System.out.println( 35 & (16-1));
//        System.out.println(35 % 16);
        int x = 6;
        System.out.println(31*x == (x<<5)-x);

//        http://wiki.jikexueyuan.com/project/java-enhancement/java-thirtysix.html
        int[] ints = {1,2,3,4,5};
        List list = Arrays.asList(ints);  // List<ints[]>
        System.out.println("list'size：" + list.size());


        Integer[] ints2 = {1,2,3,4,5};
        List list2 = Arrays.asList(ints2);  //List<Integer>
        System.out.println("list2'size：" + list2.size());


    }

}