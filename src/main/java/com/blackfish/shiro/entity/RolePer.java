package com.blackfish.shiro.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
 * role_per
 * @author 
 */
@ApiModel(value="com.blackfish.shiro.entity.RolePer")
@Data
public class RolePer implements Serializable {
    /**
     * 表主键id
     */
    @ApiModelProperty(value="表主键id")
    private Integer id;

    /**
     * 角色表的主键id
     */
    @ApiModelProperty(value="角色表的主键id")
    @TableField("roleId")
    private String roleId;

    /**
     * 权限表的主键id
     */
    @ApiModelProperty(value="权限表的主键id")
    @TableField("perId")
    private String perId;

    private static final long serialVersionUID = 1L;
}