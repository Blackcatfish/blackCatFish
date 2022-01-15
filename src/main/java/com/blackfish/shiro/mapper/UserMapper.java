package com.blackfish.shiro.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blackfish.shiro.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.LinkedHashMap;

/**
 * @author : wuwensheng
 * @date : 9:22 2020/7/1
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    User selectById(@Param("userId") String userId);

    LinkedHashMap<String, Object> selectUserPermissionById(@Param("userId") String userId);

    User selectByName(@Param("userName") String userName);

    LinkedHashMap<String, Object> selectUserPermissionByName(@Param("userName") String userId);

    void insertUser(@Param("user") User user);
}
