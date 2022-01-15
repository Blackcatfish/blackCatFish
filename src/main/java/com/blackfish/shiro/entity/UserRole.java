package com.blackfish.shiro.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
 * user_role
 * @author 
 */
@ApiModel(value="com.blackfish.shiro.entity.UserRole")
@Data
public class UserRole implements Serializable {
    /**
     * 表主键id
     */
    @TableField("id")
    @ApiModelProperty(value="表主键id")
    private Integer id;

    /**
     * 帐号表的主键id
     */
    @ApiModelProperty(value="帐号表的主键id")
    @TableField("userId")
    private String userId;

    /**
     * 角色表的主键id
     */
    @ApiModelProperty(value="角色表的主键id")
    @TableField("roleId")
    private String roleId;

    private static final long serialVersionUID = 1L;
}