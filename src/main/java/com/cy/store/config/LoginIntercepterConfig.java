package com.cy.store.config;

import com.cy.store.intercepter.LoginIntercepter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;

/**
 * @ClassName LoginIntercepterConfig
 * @Description 注册拦截器
 * @Author Yxl
 * @Date 2022/1/21 23:23
 * @Version 1.0
 **/

@Configuration
public class LoginIntercepterConfig implements WebMvcConfigurer {

    @Autowired
    private LoginIntercepter handlerInterceptor;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("/bootstrap3/**");
        strings.add("/css/**");
        strings.add("/images/**");
        strings.add("/js/**");
        strings.add("/web/login.html");
        strings.add("/web/index.html");
        strings.add("/web/product.html");
        strings.add("/web/register.html");
        strings.add("/users/reg");
        strings.add("/users/login");
        strings.add("/districts/**");

        registry.addInterceptor(handlerInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(strings);

    }
}
