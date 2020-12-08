package com.myy.securitydemo.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PageInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("perHandle");
        HttpSession session = request.getSession();
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if ("user".equals(cookie.getName())) {
                if (cookie.getValue() != null && cookie.getValue() != ""){
                    if (cookie.getValue().equals(session.getAttribute("user"))){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
