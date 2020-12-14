package com.myy.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//@Configuration
public class PageSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("myy")
                .password("123")
                .roles("user");
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated();

        //登录配置
        http.formLogin()
                .loginPage("/login.html")
                .loginProcessingUrl("/login")//security的登录接口,默认url和loginPage一样的不过是post请求
//                .usernameParameter("username")//设置传入的参数名称,默认username
//                .passwordParameter("password")//设置传入的参数名称,默认password
//                .successForwardUrl("/home.html") //请求转发
                .defaultSuccessUrl("/home.html")//重定向
                .permitAll();

        //注销配置
        http.logout()
//                .logoutUrl("/logout")//默认
                .logoutSuccessUrl("/login.html")
//                .invalidateHttpSession(true) //默认
//                .clearAuthentication(true)   //默认
                .permitAll();


        http.csrf().disable();
    }
}














