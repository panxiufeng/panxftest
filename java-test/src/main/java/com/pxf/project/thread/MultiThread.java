
package com.pxf.project.thread;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 *
 * @author panxiufeng
 * @version Id: MultiThread.java, v 0.1 2019/4/17 13:59 panxiufeng Exp $$
 */
public class MultiThread {

    public static void main(String[] args) {

        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false,false);

        for(ThreadInfo threadInfo:threadInfos ){
            System.out.println(threadInfo.getThreadId()+"===="+threadInfo.getThreadName());
        }
    }
}