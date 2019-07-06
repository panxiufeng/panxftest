
package com.pxf.project.thread;

/**
 *
 * @author panxiufeng
 * @version Id: PublicPart.java, v 0.1 2018/12/28 13:58 panxiufeng Exp $$
 */
public class PublicPart {

    private static String userName ;
    private static String userPwd ;


//    public static synchronized  void doSomething(String user_name,String user_pwd){
    public static void doSomething(String user_name,String user_pwd){

        try {
            userName = user_name;
            if(user_name.endsWith("2")){
                Thread.sleep(5000);
            }
            userPwd = user_pwd;
            System.out.println("userName="+userName+" ; userPwd="+userPwd+"      "+Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}