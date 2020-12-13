package com.myy.shiro_1;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.subject.Subject;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        DefaultSecurityManager manager = new DefaultSecurityManager();

        //添加MD5
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher("md5");
        matcher.setHashIterations(1024);//设置散列次数
        CustomRealm realm = new CustomRealm();
        realm.setCredentialsMatcher(matcher);

        manager.setRealm(realm);
        SecurityUtils.setSecurityManager(manager);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("jojo","123");

        try{
            subject.login(token);
            System.out.println("登录成功!");
        }catch (UnknownAccountException e){
            System.out.println("账号不存在!");
        }catch (IncorrectCredentialsException e){
            System.out.println("密码错误!");
        }
        System.out.println("================");

        //角色权限
        if (subject.isAuthenticated()){
            //单权限
            boolean a = subject.hasRole("admin");
            System.out.println(a);
            System.out.println("---------------");
            //所有权限
            boolean b = subject.hasAllRoles(Arrays.asList("admin","user"));
            System.out.println(b);
            System.out.println("---------------");
            //多权限
            boolean[] cs = subject.hasRoles(Arrays.asList("admin","user"));
            for (boolean c : cs){
                System.out.println(c);
            }
        }
        System.out.println("================");
        //资源权限
        if (subject.isAuthenticated()){
            //
            boolean a = subject.isPermitted("user:select:01");
            System.out.println(a);
            System.out.println("---------------");
        }
    }
}
