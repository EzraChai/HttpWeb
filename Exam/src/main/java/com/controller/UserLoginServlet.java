package com.controller;

import com.dao.userDao;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

public class UserLoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        userDao dao = new userDao();
        String email, password;
        int result = 0;
        req.setCharacterEncoding("utf-8");

        email = req.getParameter("Email");
        password = req.getParameter("Password");

        Date date = new Date();
        result = dao.login(email, password,req);
        Date date2 = new Date();
        System.out.println((date2.getTime() - date.getTime())+ " milliseconds");
        if (result == 1) {
            HttpSession session = req.getSession();
            resp.sendRedirect("/Exam/index.html");
        } else {
            resp.sendRedirect("/Exam/loginError.html");
        }
    }
}
