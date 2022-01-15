package com.blackfish.shiro.controller;

import com.blackfish.shiro.entity.SysRole;
import com.blackfish.service.RoleService;
import com.blackfish.shiro.vo.R;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @Description:
 * @Author: zly
 * @Version: V1.0.0
 * @Since: 1.0
 * @Date: 2021/7/10
 */
@RestController
@RequestMapping("/role")
@Api(tags = "角色")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @PostMapping(value = "/save")
    public R save(@RequestBody @Valid SysRole sysRole) {
        roleService.save(sysRole);
        return R.ok();
    }
}
