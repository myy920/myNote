package com.myy.security.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AndRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.io.PrintWriter;

@Configuration
public class FristSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("jack").password(new BCryptPasswordEncoder().encode("abc")).roles("user");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().mvcMatchers();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/html/login.html")
                .loginProcessingUrl("/doLogin")
                .successHandler((request, response, authentication) -> {
                    response.setContentType("application/json,charset=utf-8");
                    PrintWriter out = response.getWriter();
                    out.write(new ObjectMapper().writeValueAsString(authentication.getPrincipal()));
                    out.flush();
                    out.close();
                })
                .failureHandler((request, response, exception) -> {
                    response.setContentType("application/json,charset=utf-8");
                    PrintWriter out = response.getWriter();
                    out.write(new ObjectMapper().writeValueAsString(exception.getMessage()));
                    out.flush();
                    out.close();
                })
                .permitAll()
                .and()
                .csrf().disable();
    }
}
