package com.blackfish.service;

import com.blackfish.shiro.entity.User;
import com.blackfish.shiro.vo.R;
import com.blackfish.shiro.vo.TokenVO;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description:
 * @Author: zly
 * @Version: V1.0.0
 * @Since: 1.0
 * @Date: 2021/6/14
 */
public interface UserService {
    @Transactional
    R register(User user);

    TokenVO passWordLogin(String userId, String passWord);

    void sendVerificationCode(String userId);

    String verificationCodeLogin(String userId, String code);

}
