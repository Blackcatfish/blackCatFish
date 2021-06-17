package com.blackfish.config;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.blackfish.entity.User;
import com.blackfish.vo.TokenVO;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

public class ShiroFilter extends BasicHttpAuthenticationFilter {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    //token 30分钟后刷新，3小时过期
    private static long maxMillis = 2 * 60 * 1000l;

    /**
     * 如果带有 token，则对 token 进行检查，否则直接通过
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {

        logger.info("进入filter");
        // 如果没有携带token
        if (!isLoginAttempt(request, response)) {
            publicLoginErrorController(response, "没有用于验证的token, 请重新登陆");
            return false;
        }

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        String token = httpServletRequest.getHeader(CommonConstant.HEADER_JWT_TOKEN_NAME);
        // 解析token中的信息
        User infoFromToken = JWTUtil.getInfoFromToken(token);
        if (infoFromToken == null || (StrUtil.isBlank(infoFromToken.getUserName()))) {
            publicLoginErrorController(response, "登陆超时解析不了token, 请重新登陆");
            return false;
        }

        // 通过username取redis中查询
//        Object redisTokenRealValueString = RedisUtil.get(infoFromToken.getUsername());
//        if (null == redisTokenRealValueString) {
//            publicLoginErrorController(response, "登陆超时没有对应用户, 请重新登陆");
//            return false;
//        }
//        Map<String, Object> redisTokenMap = (HashMap<String, Object>) redisTokenRealValueString;
//
//        // 获取redis中的token
//        String redisToken = (String) redisTokenMap.get("token");
//        if (StrUtil.isEmpty(token) || (!redisToken.equals(token))) {
//            publicLoginErrorController(response, "token和redis里面不匹配, 请重新登陆04");
//            return false;
//        }
        //token过期时间 这里单位为秒
//        long EFFECT_TIME = beanTool.getBean(SysConfigurationProperties.class).getRedisEffectTime();
//        //token刷新间隔时间 这里单位为秒
//        Integer refreshTokenTime = beanTool.getBean(SysConfigurationProperties.class).getRefreshTokenTime();
//        //token过期时间距离当前时间小于等于3分钟的话，就执行刷新替换动作
//        Date tokenExpireTime = (Date) redisTokenMap.get("expireDate");
//        long time = tokenExpireTime.getTime();
//        System.out.println(time);

//        long millis = tokenExpireTime.getTime() - Calendar.getInstance().getTimeInMillis();
//        if (millis < 0) {
//            publicLoginErrorController(response, "登陆超时, 请重新登陆");
//            return false;
//        } else if ((EFFECT_TIME * 1000 - millis) > refreshTokenTime * 1000) {
//            // 执行刷新动作, 返回新的token
//            TokenVO tokenVO = refreshToken(token, httpServletResponse);
//            token = tokenVO.getToken();
//        }
        JwtToken jwtToken = new JwtToken(token);
        this.getSubject(request, response).login(jwtToken);

        return true;
    }

    /**
     * 验证用户的登入。
     * 检测 cookie 里面是否包含 Token 字段
     */
    @Override
    protected boolean isLoginAttempt(ServletRequest request, ServletResponse response) {
        HttpServletRequest req = (HttpServletRequest) request;//CommonConstant.COOKIE_JWT_TOKEN_NAME
        String token = req.getHeader(CommonConstant.HEADER_JWT_TOKEN_NAME);
        if (token == null) {
            return false;
        }
        return StrUtil.isNotEmpty(token);
    }

    /**
     *
     */
    public void publicLoginErrorController(ServletResponse response, String message) {
        try {
            HttpServletResponse response1 = (HttpServletResponse) response;
            response1.setContentType("application/json;charset=UTF-8");
            response1.getWriter().write(JSONUtil.toJsonStr("登陆超时"));
        } catch (IOException e) {
            logger.error("IOException");
        }
    }

    // 刷新token
    private TokenVO refreshToken(String oldToken, HttpServletResponse response) {
        User infoFromToken = JWTUtil.getInfoFromToken(oldToken);
        TokenVO tokenVO = JWTUtil.generateToken(infoFromToken);
        HashMap<Object, Object> redisTokenMap = new HashMap<>();
        redisTokenMap.put(CommonConstant.JWT_TOKEN_MAP_KEY_TOKEN, tokenVO.getToken());
        redisTokenMap.put(CommonConstant.JWT_TOKEN_MAP_KEY_TOKEN_EXPIRE_DATE, tokenVO.getExpireDate());
//        RedisUtil.set(infoFromToken.getUserName(), redisTokenMap, tokenVO.getEffectTime());
        response.setHeader(CommonConstant.HEADER_JWT_TOKEN_NAME, tokenVO.getToken());
        return tokenVO;
    }

    /**
     * 设置权限验证不通过返回200 修改默认的401
     *
     * @param request
     * @param response
     * @return
     */
    @Override
    protected boolean sendChallenge(ServletRequest request, ServletResponse response) {
        HttpServletResponse httpResponse = WebUtils.toHttp(response);
        httpResponse.setStatus(HttpServletResponse.SC_OK);
        return false;
    }
}
