package com.wdd.studentmanager.interceptors;

import com.wdd.studentmanager.domain.Admin;
import com.wdd.studentmanager.util.Const;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Classname LoginInterceptor
 * @Description 登录拦截器
 * @Date 2019/6/25 16:09
 * @Created by WDD
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        Admin user = (Admin)request.getSession().getAttribute(Const.ADMIN);
        if(StringUtils.isEmpty(user)){
            response.sendRedirect(request.getContextPath() + "/system/login");
            return false;
        }
        return true;
    }

}
