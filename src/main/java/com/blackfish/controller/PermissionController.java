package com.blackfish.controller;

import com.blackfish.entity.SysPermissions;
import com.blackfish.service.PermissionService;
import com.blackfish.vo.R;
import io.swagger.annotations.Api;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: zly
 * @Version: V1.0.0
 * @Since: 1.0
 * @Date: 2021/7/10
 */
@RestController
@RequestMapping("/per")
@Api(tags = "权限")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;

    @RequiresRoles(value = {"admin"})
    @PostMapping("/save")
    public R save(@RequestBody SysPermissions sysPermissions) {
        permissionService.save(sysPermissions);
        return R.ok();
    }

}
