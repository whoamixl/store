package com.cy.store.intercepter;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @ClassName LoginIntercepter
 * @Description TODO
 * @Author Yxl
 * @Date 2022/1/21 23:08
 * @Version 1.0
 **/

@Component
public class LoginIntercepter implements HandlerInterceptor {

    /**
     * @Description:检测全局session中是否有uid数据，如果有则放行，如果没有则重定向到登录页
     * @Author: xiaolong
     * @Date: 2022/1/21 23:12
     * @param request: 请求对象
     * @param response:返回对象
     * @param handler:处理器
     * @return: boolean 如果返回值为true则放行，如果为false则表示拦截请求
     **/
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Object uid = session.getAttribute("uid");
        if (uid==null){
            response.sendRedirect("/web/login.html");
            return false;
        }
        return true;
    }
}
