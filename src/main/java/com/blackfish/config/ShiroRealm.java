package com.blackfish.config;

import com.blackfish.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

@Component
public class ShiroRealm extends AuthorizingRealm {


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
        String username = infoFromToken.getUserName();
//        List<Ro> roles = roleMapper.selectRolesByUserName(username);
//        Set<String> roleSets = new HashSet<>();
//        HashSet<String> permissions = new HashSet<>();
//        if (CollectionUtil.isEmpty(roles)) {
//            info.setRoles(null);
//            info.setStringPermissions(null);
//        } else {
//            for (Role role : roles) {
//                roleSets.add(role.getRoleName());
//            }
//            info.setRoles(roleSets);
//            List<String> permissionsList = roleMapper.selectUserMenusPerms(username);
//            for (String s : permissionsList) {
//                permissions.add(s);
//            }
//            //权限
//            info.setStringPermissions(permissions);
//        }
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

