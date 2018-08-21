package com.pxf.project.common.util;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class CookieUtil {

    private static Logger log              = LoggerFactory.getLogger(CookieUtil.class);

    public static final String  SESSSIONID       = "sessionid";
    public static final int     SESSIONID_EXPIRE = 30 * 60;
    private final static String defEncode        = "UTF-8";

    public static void addCookie(String path, String name, String value, HttpServletResponse resp) {
        addCookie(path, name, value, resp, -1);
    }

    public static void addCookie(String path, String name, String value, HttpServletResponse resp,
                                 int timeout) {
        if (StringUtils.isEmpty(path)) {
            path = "/";
        }

        try {
            if (!StringUtils.isEmpty(value)) {
                value = URLEncoder.encode(value, defEncode);
            }
            Cookie cookie;
            cookie = new Cookie(name, value);
            cookie.setPath(path);
            cookie.setMaxAge(timeout);
            resp.addCookie(cookie);

        } catch (UnsupportedEncodingException e) {
            log.error("添加cookie失败", e);
        }
    }

    /**
     * 根据名称取得请求中的cookie对象
     * 
     * @param request
     * @param name
     * @return
     */
    public static Cookie getCookie(HttpServletRequest request, String name) {
        Cookie cookies[] = request.getCookies();
        if (cookies != null && null != name) {
            for (int i = 0; i < cookies.length; i++) {
                if (name.equals(cookies[i].getName())) {
                    return cookies[i];
                }
            }
        }
        return null;
    }

    /**
     * 根据名称取Cookie
     */
    public static String getCookieValue(HttpServletRequest request, String name) {
        String value = getCookieValue(request, name, defEncode);

        return Base64Util.decodeBASE64(value);
    }

    /**
     * 取得cookie值，经过编码转换
     * 
     * @param request
     * @param name
     * @param encode
     * @return
     */
    public static String getCookieValue(HttpServletRequest request, String name, String encode) {
        if (encode == null || "".equals(encode.trim())) {
            encode = defEncode; // 默认"UTF-8"
        }
        String val = getCookiePriValue(request, name);
        if (val == null)
            return null;
        try {
            return URLDecoder.decode(val, encode);
        } catch (UnsupportedEncodingException e) {
            log.error("decode cookie value failed, val=" + val, e);
            return val;
        }
    }

    /**
     * 获取未做编码转换的cookie原始值(不推荐使用)
     */
    public static String getCookiePriValue(HttpServletRequest request, String name) {
        Cookie sCookie = getCookie(request, name);
        if (sCookie == null)
            return null;
        return sCookie.getValue();
    }
}
