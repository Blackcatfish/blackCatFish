package com.blackfish.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * sys_permissions
 * @author
 */
@Table(name="sys_permissions")
@ApiModel(value="com.blackfish.entity.SysPermissions")
@Data
public class SysPermissions implements Serializable {
    /**
     * 权限表id 作为表主键 用于关联
     */
    @Id
    @GeneratedValue
    @ApiModelProperty(value="权限表id 作为表主键 用于关联")
    @TableField("perId")
    private String perId;

    /**
     * 权限名称
     */
    @ApiModelProperty(value="权限名称")
    @TableField("permissionsName")
    private String permissionsName;

    /**
     * 备注，预留字段
     */
    @ApiModelProperty(value="备注，预留字段")
    @TableField("perRemarks")
    private String perRemarks;

    private static final long serialVersionUID = 1L;
}