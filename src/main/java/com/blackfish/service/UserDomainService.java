package com.blackfish.service;


import com.blackfish.shiro.entity.User;
import com.blackfish.shiro.exception.CustomizeException;
import com.blackfish.shiro.mapper.UserMapper;
import com.blackfish.shiro.mapper.UserRoleMapper;
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


    public void register(User user) {
        // 首先检查此用户是否在数据库
        if (userMapper.selectById(user.getUserId()) != null) throw new CustomizeException("500", "该手机号已经注册");
        // 制作用户密码,然后将用户插入user表中
        String encryptPassword = CommonsUtils.encryptPassword(user.getPassword(), String.valueOf(user.getUserId()));
        log.info("加密之后的用户密码是:{}", encryptPassword);
        user.setPassword(encryptPassword);
        this.insetUser(user);
        // 增加用户角色中间表,注册最基本角色
        userRoleMapper.insert(user.getUserId(), 200);
    }

    public void insetUser(User user) {
        userMapper.insertUser(user);
    }
}
