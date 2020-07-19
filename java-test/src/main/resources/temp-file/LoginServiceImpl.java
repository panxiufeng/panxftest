//
//                            _ooOoo_
//                           o8888888o
//                           88" . "88
//                           (| -_- |)
//                           O\  =  /O
//                        ____/`---'\____
//                      .'  \\|     |//  `.
//                     /  \\|||  :  |||//  \
//                    /  _||||| -:- |||||-  \
//                    |   | \\\  -  /// |   |
//                    | \_|  ''\---/''  |   |
//                    \  .-\__  `-`  ___/-. /
//                  ___`. .'  /--.--\  `. . __
//               ."" '<  `.___\_<|>_/___.'  >'"".
//              | | :  `- \`.;`\ _ /`;.`/ - ` : | |
//              \  \ `-.   \_ __\ /__ _/   .-` /  /
//         ======`-.____`-.___\_____/___.-`____.-'======
//                            `=---='
//        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
//                      Buddha Bless, No Bug !

import com.panxf.console.biz.user.LoginService;
import com.panxf.console.client.user.LoginClient;
import com.panxf.console.common.pojo.ConsoleUser;
import com.panxf.console.common.utils.CacheKeyUtil;
import com.panxf.lang.common.enums.EnumCommonErrCode;
import com.panxf.lang.common.exception.BizException;
import com.panxf.lang.common.log.MyLog;
import com.panxf.lang.common.result.BaseResp;
import com.panxf.lang.common.result.ServiceResp;
import com.panxf.lang.common.utils.Base64Util;
import com.panxf.lang.common.utils.CookieUtil;
import com.panxf.lang.common.utils.redis.RedisUtils;
import com.panxf.user.dto.req.LoginReqDto;
import com.panxf.user.dto.req.LogoutReqDto;
import com.panxf.user.dto.resp.LoginRespDto;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description:
 * @Author panxiufeng
 * @Date 2019/5/1下午1:30
 */
@Service
public class LoginServiceImpl implements LoginService {

    private static MyLog log = MyLog.get(LoginServiceImpl.class);

    @Autowired
    private LoginClient loginClient;

    @Autowired
    private RedisUtils redisUtils;


    @Value("${login.expire}")
    private int LOGIN_EXPIRED;

    @Override
    public ServiceResp<LoginRespDto> login(LoginReqDto dto) {

        try {
            BaseResp<LoginRespDto> resp = loginClient.login(dto);
            if(resp.isSuccess()){
                return new ServiceResp<LoginRespDto>(resp.getData());
            }
            return new ServiceResp<LoginRespDto>(false,resp.getRespCode(),resp.getRespMsg());
        } catch(BizException se){
            log.error("用户登陆异常:", se);
            return new ServiceResp<LoginRespDto>(false, se.getMsgCode(), se.getMessage());
        } catch (Exception e) {
            log.error("用户登陆异常:", e);
            return new ServiceResp<LoginRespDto>(false, EnumCommonErrCode.SYSTEM_ERROR.getCode(), EnumCommonErrCode.SYSTEM_ERROR.getDescript());
        }
    }

    @Override
    public ServiceResp<Void> logout(LogoutReqDto dto) {

        try {
            BaseResp<Void> resp = loginClient.logout(dto);
            if(resp.isSuccess()){
                return new ServiceResp<Void>(true);
            }
            return new ServiceResp<Void>(false,resp.getRespCode(),resp.getRespMsg());
        } catch(BizException se){
            log.error("用户登出异常:", se);
            return new ServiceResp<Void>(false, se.getMsgCode(), se.getMessage());
        } catch (Exception e) {
            log.error("用户登出异常:", e);
            return new ServiceResp<Void>(false, EnumCommonErrCode.SYSTEM_ERROR.getCode(), EnumCommonErrCode.SYSTEM_ERROR.getDescript());
        }
    }



    @Override
    public ConsoleUser checkAuth(HttpServletRequest request, String token, HttpServletResponse response) {
        if(StringUtils.isEmpty(token)) {
            return null;
        }

        ConsoleUser user = null;
        String loginkey = CacheKeyUtil.getConsoleUserKey(token);
        try {
            user = (ConsoleUser)redisUtils.get(loginkey);
        } catch (Exception e) {
            log.info("查询用户缓存异常:", e);
        }

        if (user != null) {
            //刷行 缓存和redis 的过期时间
            CookieUtil.addCookie ("/", CookieUtil.SESSSIONID, Base64Util.encodeBASE64(token), response, LOGIN_EXPIRED);
            redisUtils.expire(loginkey,LOGIN_EXPIRED);
        }

        return user;
    }

    @Override
    public boolean setAuth(String token, HttpServletRequest request, HttpServletResponse response) {
        String sessionId = CookieUtil.getCookieValue(request, CookieUtil.SESSSIONID);
        CookieUtil.addCookie ("/", CookieUtil.SESSSIONID, Base64Util.encodeBASE64(token), response, LOGIN_EXPIRED);
        if(StringUtils.isNotEmpty (sessionId)){
            request.setAttribute (CookieUtil.SESSSIONID, sessionId);
        }
        return true;
    }


    @Override
    public boolean  removeAuth(HttpServletRequest request, HttpServletResponse response,String sessionId) {
        CookieUtil.addCookie("/", sessionId, null, response, 0);
        request.removeAttribute(sessionId);
        return true;
    }
}
