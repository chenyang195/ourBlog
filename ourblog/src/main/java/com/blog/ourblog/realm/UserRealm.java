package com.blog.ourblog.realm;


import com.blog.ourblog.entity.User;
import com.blog.ourblog.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;
    /**
     * 执行授权逻辑
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行授权逻辑");

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermission("user:add");
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
        System.out.println("执行认证逻辑");


        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        User user =userService.fingByUserName(token.getUsername());

        if(null==user){
            return null;
        }
        System.out.println(user.toString());
        Object principal = user.getUsername();
        Object credentials = user.getPassword();
        ByteSource credentialsSalt = ByteSource.Util.bytes(user.getUsername());
        String realmName = getName();
        return new SimpleAuthenticationInfo(principal,credentials,credentialsSalt,realmName);
    }
}
