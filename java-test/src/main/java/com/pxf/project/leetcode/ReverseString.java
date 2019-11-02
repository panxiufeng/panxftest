
package com.pxf.project.leetcode;

/**
 *
 * @author panxiufeng
 * @version Id: ReverseString.java, v 0.1 2019/6/21 15:41 panxiufeng Exp $$
 */
public class ReverseString {

    public static void reverseString(char[] s) {

        int len = s.length;
        for(int i=0;i<len/2;i++){
            char temp = s[len-1-i];
            s[len-1-i] = s[i];
            s[i] = temp;
        }
        System.out.println(s);
    }

    public static void reverseString2(char[] s) {

        int len = s.length;
        for(int i=0;i<len/2;i++){
            s[len-1-i] = (char)(s[i] ^ s[len-1-i]);
            s[i] = (char)(s[i] ^ s[len-1-i]);
            s[len-1-i] = (char)(s[i] ^ s[len-1-i]);
        }
        System.out.println(s);
    }

    public static void reverseInt(int x) {


    }

    public static void main(String[] args) {
        char[] s = "hello".toCharArray();
        reverseString2(s);
    }
}