package com.myy.shiro_1;


import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.Arrays;


public class CustomRealm extends AuthorizingRealm {
    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String principal = (String) token.getPrincipal();//principal==jojo
        if (!"jojo".equals(principal)) {
            return new SimpleAuthenticationInfo(
                    principal,
                    "894b3913a4a13b25dc6186d11835c209",
                    ByteSource.Util.bytes("abc"),//盐值
                    this.getName());
        }
        return null;
    }

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String principal = (String) principals.getPrimaryPrincipal();
        System.out.println("身份信息:"+principal);

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        //添加角色信息权限
        authorizationInfo.addRole("admin");
        //authorizationInfo.addRole("user");

        //添加资源信息权限
        authorizationInfo.addStringPermissions(Arrays.asList("user:*:01"));
        return authorizationInfo;


    }
}
