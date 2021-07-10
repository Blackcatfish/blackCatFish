package com.blackfish.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.blackfish.entity.RolePer;
import com.blackfish.entity.SysPermissions;
import com.blackfish.entity.UserRole;
import com.blackfish.mapper.RolePerDao;
import com.blackfish.mapper.SysPermissionsDao;
import com.blackfish.mapper.UserRoleDao;
import com.blackfish.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description:
 * @Author: zly
 * @Version: V1.0.0
 * @Since: 1.0
 * @Date: 2021/7/10
 */
@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private SysPermissionsDao sysPermissionsDao;
    @Autowired
    private UserRoleDao roleDao;
    @Autowired
    private RolePerDao rolePerDao;

    @Override
    public int save(SysPermissions sysPermissions) {
        return sysPermissionsDao.insert(sysPermissions);
    }

    @Override
    public List<String> getPermissionByRoleId(String userId) {
        List<String> roleIds = roleDao.selectList(new QueryWrapper<UserRole>().lambda().eq(UserRole::getUserId, userId))
                .stream().map(UserRole::getRoleId).collect(Collectors.toList());
        List<String> perIds = rolePerDao.selectList(new QueryWrapper<RolePer>().lambda().in(RolePer::getRoleId, roleIds))
                .stream().map(RolePer::getPerId).collect(Collectors.toList());
        List<String> perNames = sysPermissionsDao.selectList(new QueryWrapper<SysPermissions>().lambda().in(SysPermissions::getPerId, perIds))
                .stream().map(SysPermissions::getPermissionsName).collect(Collectors.toList());
        return perNames;
    }
}
