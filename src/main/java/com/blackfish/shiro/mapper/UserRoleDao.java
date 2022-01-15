package com.blackfish.shiro.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blackfish.shiro.entity.UserRole;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleDao extends BaseMapper<UserRole> {
    int deleteByPrimaryKey(Integer id);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    UserRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);
}