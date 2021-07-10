package com.blackfish.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blackfish.entity.SysPermissions;
import org.springframework.stereotype.Repository;

@Repository
public interface SysPermissionsDao extends BaseMapper<SysPermissions> {
    int deleteByPrimaryKey(String perId);

    int insert(SysPermissions record);

    int insertSelective(SysPermissions record);

    SysPermissions selectByPrimaryKey(String perId);

    int updateByPrimaryKeySelective(SysPermissions record);

    int updateByPrimaryKey(SysPermissions record);
}