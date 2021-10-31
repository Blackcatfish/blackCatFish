package com.blackfish.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.Table;

/**
 * @author : zly
 * @date : 10:37 2020/7/1
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "sys_user")
@TableName("sys_user")
@Accessors(chain = true)
public class User {
    private Integer id;
    @TableField("userId")
    private String userId;
    @TableField("userName")
    private String userName;
    private String password;
    @TableField("userRemarks")
    private String userRemarks;


    public static User getUser(String userId, String userName, String encryptPassword, String remark) {
        return User.builder().userId(userId).userName(userName).password(encryptPassword).userRemarks(remark).build();
    }

    public User(String userName) {
        this.userName = userName;
    }
}
