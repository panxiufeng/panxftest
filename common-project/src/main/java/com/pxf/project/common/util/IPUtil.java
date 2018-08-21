package com.pxf.project.common.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class IPUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(IPUtil.class);

    public IPUtil() {
    }

    private static List<String> getLocalIPList() {
        ArrayList ipList = new ArrayList();

        try {
            Enumeration networkInterfaces = NetworkInterface.getNetworkInterfaces();

            while(networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = (NetworkInterface)networkInterfaces.nextElement();
                Enumeration inetAddresses = networkInterface.getInetAddresses();

                while(inetAddresses.hasMoreElements()) {
                    InetAddress inetAddress = (InetAddress)inetAddresses.nextElement();
                    if (inetAddress != null && inetAddress instanceof Inet4Address && inetAddress.isSiteLocalAddress()) {
                        String ip = inetAddress.getHostAddress();
                        ipList.add(ip);
                    }
                }
            }
        } catch (SocketException var6) {
            LOGGER.error("获取本地ip列表时出错", var6);
        }

        return ipList;
    }

    public static String getLocalIP() {
        String localHost = "";
        List<String> localIPList = getLocalIPList();
        int size = localIPList.size();
        if (size == 0) {
            LOGGER.error("获取不到本机局域网地址。");
        } else {
            localHost = (String)localIPList.get(0);
            if (size > 1) {
                LOGGER.warn("获取本机多个局域网地址，请检查，IP:{}", localIPList.toArray().toString());
            }
        }

        LOGGER.info("获取到本地局域网地址：{}", localHost);
        return localHost;
    }

    /**
     * 获得远程 ip
     *
     * @param request
     * @return String
     */
    public static String getRemoteIP(HttpServletRequest request) {
        if (request.getHeader("x-forwarded-for") == null) {
            return transIP(request.getRemoteAddr());
        }
        // 多级反向代理,取X-Forwarded-For中第一个非unknown的有效IP字符串
        if (request.getHeader("x-forwarded-for").contains(",")) {
            String[] ips = request.getHeader("x-forwarded-for").split(",");
            for (String string : ips) {
                if (!"unknown".equalsIgnoreCase(string)) {
                    return transIP(string);
                }
            }
            return "unknown";
        }
        return transIP(request.getHeader("x-forwarded-for"));
    }

    private static String transIP(String ipAddress) {
        if ("127.0.0.1".equals(ipAddress)) {
            // 根据网卡取本机配置的IP
            InetAddress inet = null;
            try {
                inet = InetAddress.getLocalHost();
                ipAddress = inet.getHostAddress();
            } catch (Exception e) {
                LOGGER.error("get ip address error", e);
            }
        }
        return ipAddress;
    }

}