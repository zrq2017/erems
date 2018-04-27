package com.zrq.interceptor;

import com.zrq.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by zrq on 2018-4-26.
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User u=(User)request.getSession().getAttribute("user");
        if(u==null){//用户不存在拦截重定向到登录页面
            response.sendRedirect("login");
            return false;
        }
        return true;
    }
}
