package com.blog.ourblog.config;

import org.apache.shiro.web.filter.authc.LogoutFilter;
import org.springframework.context.annotation.Bean;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ShiroLogoutFilter extends LogoutFilter {

    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        //清除HTTPSession的用户信息
        HttpServletRequest httpServletRequest=(HttpServletRequest) request;
        HttpSession session = httpServletRequest.getSession();
        if (session.getAttribute("user")!=null) {
            session.removeAttribute("user");
        }


        return super.preHandle(httpServletRequest, response);
    }

}
