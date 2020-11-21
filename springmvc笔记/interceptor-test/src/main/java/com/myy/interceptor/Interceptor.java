package com.myy.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Interceptor implements HandlerInterceptor {
    /**
     * perHandle(): 预处理方法
     * 在被拦截的url的目标方法之前执行：-->perHandle()-->urlMethod()
     *
     * Object handler: 该参数表示当前处理器对象
     * 返回true表示放行
     * 返回false表示请求被拦截
     *
     * 应用：过滤作用等
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return false;
    }

    /**
     *postHandle(): 后处理方法
     * url目标方法执行完成后执行: urlMethod()-->postHandle()
     *
     * ModelAndView modelAndView: urlMethod()方法的返回结果
     *
     * 应用: 对视图进行处理等
     *
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    /**
     *afterCompletion(): 请求执行完成后执行
     *
     * 应用: 资源回收
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
