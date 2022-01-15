package com.blackfish.shiro.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blackfish.shiro.entity.SysRole;
import org.springframework.stereotype.Repository;

@Repository
public interface SysRoleDao extends BaseMapper<SysRole> {
    int deleteByPrimaryKey(String roleId);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    SysRole selectByPrimaryKey(String roleId);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);
}