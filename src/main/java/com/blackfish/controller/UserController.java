package com.blackfish.controller;

import com.blackfish.dto.RegisterDTO;
import com.blackfish.service.UserService;
import com.blackfish.vo.R;
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
 * @Date: 2021/6/14
 */
@RestController
@RequestMapping("/user")
@Api(tags = "用户相关API")
public class UserController {
    @Autowired
    private UserService userService;

    //此为shiro开放端口
    @PostMapping(value = "/register", name = "用户注册")
    public R userRegister(@RequestBody @Valid RegisterDTO registerDTO) {
        userService.register(registerDTO.getUserId(), registerDTO.getUserName(), registerDTO.getPassword(), registerDTO.getRemark());
        return R.ok();
    }

}
