package com.blackfish.service;

import com.blackfish.entity.SysPermissions;

import java.util.List;

/**
 * @Description:
 * @Author: zly
 * @Version: V1.0.0
 * @Since: 1.0
 * @Date: 2021/7/10
 */
public interface PermissionService {
    /**
     * 保存权限
     *
     * @param sysPermissions
     * @return
     */
    int save(SysPermissions sysPermissions);

    /**
     * 根据用户角色获取相应的权限
     *
     * @param userId
     * @return
     */
    List<String> getPermissionByRoleId(String userId);
}
