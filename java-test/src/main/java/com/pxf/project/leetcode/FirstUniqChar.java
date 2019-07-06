
package com.pxf.project.leetcode;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author panxiufeng
 * @version Id: FirstUniqChar.java, v 0.1 2019/5/22 9:19 panxiufeng Exp $$
 */
public class FirstUniqChar {

    public static int firstUniqChar(String s) {
        char[] sArr = s.toCharArray();
        Map<Character,Integer> uniqMap = new HashMap<Character,Integer>();
        for(int i=0;i<sArr.length;i++){
            if(uniqMap.containsKey(sArr[i])){
                uniqMap.put(sArr[i],-1);
            }else{
                uniqMap.put(sArr[i],i);
            }
        }

        for(int i=0;i<sArr.length;i++){
            if(uniqMap.get(sArr[i]) != -1){
                return uniqMap.get(sArr[i]);
            }
        }
        return -1;
    }


    public static void main(String[] args) {

        Date d = new Date();
        
        System.out.println(firstUniqChar ("aadadaad"));
        System.out.println("----->"+(new Date().getTime()-d.getTime()));
    }
}