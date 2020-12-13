package com.myy;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;

public class ShiroDemo {
    public static void main(String[] args) {
        //创建安全管理器
        DefaultSecurityManager manager = new DefaultSecurityManager();
        //设置安全管理器的realm
        manager.setRealm(new IniRealm("classpath:shiro.ini"));
        //设置全局安全工具类的安全管理器
        SecurityUtils.setSecurityManager(manager);
        //获取主体
        Subject subject = SecurityUtils.getSubject();
        //创建令牌
        UsernamePasswordToken token = new UsernamePasswordToken("jack", "123");

        try {
            //验证token
            subject.login(token);
        } catch (UnknownAccountException e){
            System.out.println("账号不存在!");
        }
        catch (IncorrectCredentialsException e){
            System.out.println("密码错误!");
        }
    }
}
