package com.blackfish.shiro.vo;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

/**
 * @Description:
 * @Author: zly
 * @Version: V1.0.0
 * @Since: 1.0
 * @Date: 2021/6/19
 */
@Data
@Validated
public class UserLoginVo {
    @NotBlank(message = "用户ID不能为空")
    String userId;
    @NotBlank(message = "密码不能为空")
    String password;
}
