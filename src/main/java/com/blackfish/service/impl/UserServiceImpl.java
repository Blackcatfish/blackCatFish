package com.blackfish.service.impl;

import com.blackfish.config.JWTUtil;
import com.blackfish.entity.User;
import com.blackfish.mapper.UserMapper;
import com.blackfish.service.UserDomainService;
import com.blackfish.service.UserService;
import com.blackfish.util.CommonsUtils;
import com.blackfish.vo.R;
import com.blackfish.vo.TokenVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: zly
 * @Version: V1.0.0
 * @Since: 1.0
 * @Date: 2021/6/14
 */
@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserDomainService userDomainService;
    @Autowired
    private UserMapper userMapper;



    @Override
    public TokenVO passWordLogin(String userId, String passWord) {
//        return userDomainService.passwordLogin(userId,passWord);
        User user = userMapper.selectById(userId);
        if (user!=null){
            if (user.getPassword().equals(CommonsUtils.encryptPassword(passWord,userId))){
                return JWTUtil.generateToken(user);
            }
        }
        return null;
    }

    @Override
    public R register(String userId, String userName, String password, String remark) {
        //现在开始用户注册
        userDomainService.register(userId,userName,password,remark);
        return R.ok();
    }

    @Override
    public void sendVerificationCode(String userId) {
//        userDomainService.sendVerificationCode(userId);
    }

    @Override
    public String verificationCodeLogin(String userId, String code) {
//        return userDomainService.verificationCodeLogin(userId,code);
        return "";
    }

}
