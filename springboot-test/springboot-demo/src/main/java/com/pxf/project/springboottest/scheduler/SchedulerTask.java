package com.pxf.project.springboottest.scheduler;

import org.springframework.stereotype.Component;

/**
 * @ClassName: SchedulerTask
 * @Description: TODO
 * @Author panxiufeng
 * @Date 2018/8/11下午11:11
 */

/**
 * @Scheduled 参数可以接受两种定时的设置，一种是我们常用的cron="" ,一种是 fixedRate = 6000，两种都表示每隔六秒打印一下内容。
fixedRate 说明
 *   @Scheduled(fixedRate = 6000) ：上一次开始执行时间点之后6秒再执行
 *   @Scheduled(fixedDelay = 6000) ：上一次执行完毕时间点之后6秒再执行
 *   @Scheduled(initialDelay=1000, fixedRate=6000) ：第一次延迟1秒后执行，之后按fixedRate的规则每6秒执行一次
 */
@Component
public class SchedulerTask {

    private int count=0;

//    @Scheduled(cron="*/50 * * * * ?")
//    private void process(){
//        System.out.println("this is scheduler task runing  "+(count++));
//    }
}
