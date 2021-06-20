package com.blackfish.service;

import com.blackfish.vo.R;
import com.blackfish.vo.TokenVO;
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
    R register(String userId, String userName, String password, String remark);

    TokenVO passWordLogin(String userId, String passWord);

    void sendVerificationCode(String userId);

    String verificationCodeLogin(String userId, String code);

}
