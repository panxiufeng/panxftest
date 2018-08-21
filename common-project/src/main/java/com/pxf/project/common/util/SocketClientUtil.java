package com.pxf.project.common.util;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketClientUtil {
    public SocketClientUtil() {
    }

    public static void send(String xml, String ip, int port) {
        Socket socket = null;
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        OutputStream outputStream = null;
        PrintWriter printWriter = null;

        try {
            socket = new Socket(ip, port);
            System.out.println("==================================================");
            System.out.println(String.format("连接地址IP:[%s],端口:[%s]", ip, port));
            outputStream = socket.getOutputStream();
            printWriter = new PrintWriter(outputStream);
            System.out.println(String.format("请求信息:[%s]", xml));
            printWriter.print(xml);
            printWriter.flush();
            socket.shutdownOutput();
            inputStream = socket.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream);
            bufferedReader = new BufferedReader(inputStreamReader);
            StringBuffer sb = new StringBuffer();
            String temp = null;

            while((temp = bufferedReader.readLine()) != null) {
                sb.append(temp);
            }

            System.out.println(String.format("返回信息:[%s]", sb.toString()));
            System.out.println("==================================================");
        } catch (UnknownHostException var36) {
            var36.printStackTrace();
        } catch (IOException var37) {
            var37.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException var35) {
                var35.printStackTrace();
            }

            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException var34) {
                var34.printStackTrace();
            }

            if (printWriter != null) {
                printWriter.close();
            }

            try {
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException var33) {
                var33.printStackTrace();
            }

            try {
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException var32) {
                var32.printStackTrace();
            }

        }

    }

    public static void main(String[] args) {
        String xml = "<?xml version=\"1.0\" encoding=\"gbk\"?><Service>    <Service_Header>        <msg_interval>30</msg_interval>       <msg_expiry>36000</msg_expiry>      <service_response>            <status>COMPLETE</status>            <code>S000A000</code>            <desc>交易成功</desc>            <requester_code/><requester_desc/></service_response><msglog>1</msglog><timeout>3000</timeout><name>统一对账信息查询</name><service_id>00010000725100</service_id><requester_id>0044</requester_id><branch_id>866777777</branch_id><channel_id>96</channel_id><version_id>01</version_id><service_time>20161208164120</service_time><service_sn>8667777770579016412</service_sn><start_timestamp>2016-12-08 16:41:20.162</start_timestamp>        <trace_msg>IBM.SERVICE.RES.OUTPUT-return reponse to requester</trace_msg>        <end_timestamp>2016-12-08 16:41:20.983</end_timestamp>    </Service_Header>    <Service_Body>    </Service_Body></Service>";
        send(xml, "localhost", 9052);
    }
}