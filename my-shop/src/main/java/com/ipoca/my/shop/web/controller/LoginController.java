package com.ipoca.my.shop.web.controller;

import com.ipoca.my.shop.commons.context.SpringContext;
import com.ipoca.my.shop.commons.utils.CookieUtils;
import com.ipoca.my.shop.entity.User;
import com.ipoca.my.shop.service.UserService;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginController extends HttpServlet {

    private static final String USER_INFO_COOKIE_NAME = "userInfo";

    private UserService userService = SpringContext.getBean("userService");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userInfoValue = CookieUtils.getCookieValue(req,USER_INFO_COOKIE_NAME);
        if (StringUtils.isNoneBlank(userInfoValue)){
            String[] arrValues = userInfoValue.split(":");
            req.setAttribute("email", arrValues[0]);
            req.setAttribute("password", arrValues[1]);
            req.setAttribute("isRemember", true);

        }
        req.getRequestDispatcher("/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        String password = req.getParameter("password");
        boolean isRemember = req.getParameter("isRemember") == null ? false : true;
        User admin = userService.login(email,password);

        //登陆成功
        if (admin != null){
            if (isRemember){
                CookieUtils.setCookie(req,resp,USER_INFO_COOKIE_NAME,String.format("%s:%s",email,password));
            } else {
                CookieUtils.deleteCookie(req,resp,USER_INFO_COOKIE_NAME);
            }
            resp.sendRedirect("main.jsp");
        }
        //登陆失败
        else {
            req.setAttribute("message","用户名或者密码错误");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }
    }

}
