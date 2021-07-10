package com.blackfish.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.blackfish.entity.SysRole;
import com.blackfish.entity.UserRole;
import com.blackfish.mapper.SysRoleDao;
import com.blackfish.mapper.UserRoleDao;
import com.blackfish.service.RoleService;
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
public class RoleServiceImpl implements RoleService {
    @Autowired
    private SysRoleDao sysRoleDao;
    @Autowired
    private UserRoleDao roleDao;

    @Override
    public int save(SysRole sysRole) {
        return sysRoleDao.insert(sysRole);
    }

    @Override
    public List<String> getRoleList(String userId) {
        List<UserRole> userRoles = roleDao.selectList(new QueryWrapper<UserRole>().lambda().eq(UserRole::getUserId, userId));
        List<String> roleIds = userRoles
                .stream().map(UserRole::getRoleId).collect(Collectors.toList());
        List<String> roleNames = sysRoleDao.selectList(new QueryWrapper<SysRole>().lambda().in(SysRole::getRoleId, roleIds))
                .stream().map(SysRole::getRoleName).collect(Collectors.toList());
        return roleNames;
    }
}
