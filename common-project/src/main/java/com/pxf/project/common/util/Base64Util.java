package com.pxf.project.common.util;

import org.apache.commons.net.util.Base64;

/**
 * Base64 编码与解码
 * 
 */
public class Base64Util {

    /**
     * 编码
     * 
     * @param str
     * @return
     */
    public static String encodeBASE64(String str) {
        if (str == null)
            return null;
        return Base64.encodeBase64String(str.getBytes());
    }

    /**
     * 解码
     * 
     * @param str
     * @return
     */
    public static String decodeBASE64(String str) {
        if (str == null)
            return null;
        try {
            byte[] dataBytes = Base64.decodeBase64(str);
            return new String(dataBytes);
        } catch (Exception e) {
            return null;
        }
    }




    public static void main(String[] args) {
        System.out.println(Base64Util.decodeBASE64(Base64Util.encodeBASE64("hundsun")));
    }

}
