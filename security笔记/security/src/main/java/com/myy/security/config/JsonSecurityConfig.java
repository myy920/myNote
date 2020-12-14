package com.myy.security.config;

import com.alibaba.fastjson.JSON;
import com.myy.security.entity.RespBean;
import com.myy.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.PrintWriter;

@Configuration
public class JsonSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin/**").hasRole("admin")
                .antMatchers("/user/**").hasRole("user")
                .anyRequest().authenticated();

        //登录设置
        http.formLogin()
                .loginPage("/login.html")
                .loginProcessingUrl("/login")
                .successHandler((request, response, authentication) -> {
                    RespBean respBean = RespBean.ok("登录成功!");
                    response.setContentType("application/json;charset=utf-8");
                    PrintWriter out = response.getWriter();
                    out.write(JSON.toJSONString(respBean));
                    out.flush();
                    out.close();
                })
                .failureHandler((request, response, exception) -> {
                    RespBean respBean = RespBean.error(exception.getMessage());
                    if (exception instanceof BadCredentialsException) {
                        respBean.setMsg("用户名或密码错误!");
                    }
                    response.setContentType("application/json;charset=utf-8");
                    PrintWriter out = response.getWriter();
                    out.write(JSON.toJSONString(respBean));
                    out.flush();
                    out.close();
                })
                .permitAll();
        //注销设置
        http.logout()
                .logoutSuccessHandler((request, response, authentication) -> {
                    RespBean respBean = RespBean.ok("注销成功!");
                    response.setContentType("application/json;charset=utf-8");
                    PrintWriter out = response.getWriter();
                    out.write(JSON.toJSONString(respBean));
                    out.flush();
                    out.close();
                })
                .permitAll();
        //无状态验证
        http.exceptionHandling()
                .authenticationEntryPoint((request, response, exception) -> {
                    RespBean respBean = RespBean.error((exception.getMessage()));
                    if (exception instanceof InsufficientAuthenticationException) {
                        respBean.setStatus(401);
                        respBean.setMsg("尚未登录,请登录!");
                    }
                    response.setContentType("application/json;charset=utf-8");
                    PrintWriter out = response.getWriter();
                    out.write(JSON.toJSONString(respBean));
                    out.flush();
                    out.close();
                });
        //csrf设置
        http.csrf().disable();

    }


}

























