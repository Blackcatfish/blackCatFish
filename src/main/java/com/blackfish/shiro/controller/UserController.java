package com.blackfish.shiro.controller;

import com.blackfish.shiro.dto.RegisterDTO;
import com.blackfish.shiro.entity.User;
import com.blackfish.service.UserService;
import com.blackfish.shiro.vo.R;
import com.blackfish.shiro.vo.TokenVO;
import com.blackfish.shiro.vo.UserLoginVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresRoles;
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
 * @Date: 2021/6/14
 */
@RestController
@RequestMapping("/user")
@Api(tags = "用户相关API")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/register", name = "用户注册")
    @ApiOperation("用户注册")
    public R userRegister(@RequestBody @Valid RegisterDTO registerDTO) {
        User user = User.builder().userId(registerDTO.getUserId()).userName(registerDTO.getUserName()).password(registerDTO.getPassword()).userRemarks(registerDTO.getRemark()).build();
        userService.register(user);
        return R.ok();
    }

    @PostMapping(value = "/login", name = "用户登陆")
    @ApiOperation("用户登陆")
    public TokenVO userRegister(@RequestBody @Valid UserLoginVo userLoginVo) {

        return userService.passWordLogin(userLoginVo.getUserId(), userLoginVo.getPassword());
    }

    @PostMapping(value = "/test", name = "用户登陆")
    @RequiresRoles("admin")
    @ApiOperation("登陆验证")
    public String test() {

        return "登陆之后才能访问的内容";
    }

}
