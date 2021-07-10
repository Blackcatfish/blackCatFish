package com.blackfish.service;

import com.blackfish.entity.SysRole;
import com.blackfish.mapper.SysRoleDao;
import com.sun.jnlp.BasicServiceImpl;

import javax.jnlp.BasicService;
import java.util.List;

/**
 * @Description:
 * @Author: zly
 * @Version: V1.0.0
 * @Since: 1.0
 * @Date: 2021/7/10
 */
public interface RoleService  {
    /**
     * 保存角色
     * @param sysRole
     * @return
     */
    int save(SysRole sysRole);

    /**
     * 根据用户ID获取角色
     * @param userId
     * @return
     */
    List<String> getRoleList(String userId);
}
