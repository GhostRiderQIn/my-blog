package com.qin.Interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: my-blog
 * @description: 登陆拦截器
 * @author: qinda
 * @create: 2020-04-13 21:23
 **/
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getSession().getAttribute("user") == null)
        {
            request.setAttribute("message","请先登录");
            request.getRequestDispatcher("/admin").forward(request,response);
            return false;
        }
        else
            return true;
    }
}
