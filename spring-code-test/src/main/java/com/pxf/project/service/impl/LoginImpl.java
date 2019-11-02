
package com.pxf.project.service.impl;

import com.pxf.project.service.ILogin;
import org.springframework.stereotype.Component;

/**
 *
 * @author panxiufeng
 * @version Id: LoginImpl.java, v 0.1 2019/6/5 11:30 panxiufeng Exp $$
 */
@Component
public class LoginImpl implements ILogin {

    @Override
    public String loginCheck(String userName, String password) {
        System.out.println(userName+"----->登录成功...");
        return "success";
    }
}