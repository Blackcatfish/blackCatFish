package com.blackfish.shiro.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blackfish.shiro.entity.RolePer;
import org.springframework.stereotype.Repository;

@Repository
public interface RolePerDao extends BaseMapper<RolePer> {
    int deleteByPrimaryKey(Integer id);

    int insert(RolePer record);

    int insertSelective(RolePer record);

    RolePer selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RolePer record);

    int updateByPrimaryKey(RolePer record);
}