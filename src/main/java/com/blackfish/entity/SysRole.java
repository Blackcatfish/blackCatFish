package com.blackfish.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
 * sys_role
 * @author 
 */
@ApiModel(value="com.blackfish.entity.SysRole")
@Data

public class SysRole implements Serializable {
    /**
     *  角色id 作为表主键 用于关联
     */
    @ApiModelProperty(value=" 角色id 作为表主键 用于关联")
    @TableField("roleId")
    private String roleId;

    /**
     * 角色名
     */
    @ApiModelProperty(value="角色名")
    @TableField("roleName")
    private String roleName;

    /**
     * 备注，预留字段
     */
    @ApiModelProperty(value="备注，预留字段")
    @TableField("roleRemarks")
    private String roleRemarks;

    private static final long serialVersionUID = 1L;
}