package com.blog.ourblog.realm;


import com.blog.ourblog.entity.User;
import com.blog.ourblog.service.RoleService;
import com.blog.ourblog.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    /**
     * 执行授权逻辑
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
       String username = (String)principalCollection.getPrimaryPrincipal();
       List<String> list = roleService.getActives(username);


        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        for (String permission: list ) {
            info.addStringPermission(permission);

        }


        return info;
    }

    /**
     * 执行认证逻辑
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        Object principal= username;
        Object credentials = null;

        User user =userService.fingByUserName(username);

        if(null==user){
            return null;
        }

        String pass =user.getPassword();

        credentials = pass;
        ByteSource credentialsSalt = ByteSource.Util.bytes(user.getUsername());
        String realmName = getName();
        return new SimpleAuthenticationInfo(principal,credentials,credentialsSalt,realmName);
    }
}
