package com.blackfish.service;


import com.blackfish.entity.User;
import com.blackfish.exception.CustomizeException;
import com.blackfish.mapper.UserMapper;
import com.blackfish.mapper.UserRoleMapper;
import com.blackfish.util.CommonsUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class UserDomainService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;


    public void register(String userId, String userName, String password, String remark) {
        // 首先检查此用户是否在数据库
        if (userMapper.selectById(userId) != null) throw new CustomizeException("500", "该手机号已经注册");
        // 制作用户密码,然后将用户插入user表中
        String encryptPassword = CommonsUtils.encryptPassword(password, String.valueOf(userId));
        log.info("加密之后的用户密码是:{}", encryptPassword);
        this.insetUser(User.getUser(userId, userName, encryptPassword, remark));
        // 增加用户角色中间表,注册最基本角色
        userRoleMapper.insert(userId, 200);
    }

    public void insetUser(User user) {
        userMapper.insertUser(user);
    }
}
