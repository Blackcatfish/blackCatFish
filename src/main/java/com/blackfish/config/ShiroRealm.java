package com.blackfish.config;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.blackfish.entity.User;
import com.blackfish.mapper.UserMapper;
import com.blackfish.service.PermissionService;
import com.blackfish.service.RoleService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class ShiroRealm extends AuthorizingRealm {
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;
    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    /**
     * 获取授权信息
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String token = (String) SecurityUtils.getSubject().getPrincipal();
        User infoFromToken = JWTUtil.getInfoFromToken(token);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        String id = userMapper.selectOne(new QueryWrapper<User>().lambda().eq(User::getUserId, infoFromToken.getUserName())).getId().toString();
        List<String> roles = roleService.getRoleList(id);
        Set<String> roleSets = new HashSet<>();
        HashSet<String> permissions = new HashSet<>();
        if (CollectionUtil.isEmpty(roles)) {
            info.setRoles(null);
            info.setStringPermissions(null);
        } else {
            roleSets.addAll(roles);
            //角色
            info.setRoles(roleSets);
//            List<String> permissionsList = permissionService.getPermissionByRoleId(id);
//            permissions.addAll(permissionsList);
//            //权限
//            info.setStringPermissions(permissions);
        }
        return info;
    }

    /**
     * 身份认证
     *
     * @param authenticationToken
     * @return
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) {
        String token = (String) authenticationToken.getCredentials();

        return new SimpleAuthenticationInfo(token, token, "customRealm");
    }
}

