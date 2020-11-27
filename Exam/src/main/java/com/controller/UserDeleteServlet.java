package com.controller;

import com.Entity.User;
import com.dao.userDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UserDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        userDao Dao = new userDao();
        int result = Dao.delete(userId);
        System.out.println(result);
        resp.setContentType("text/html;chrset= utf-8");

        PrintWriter out = resp.getWriter();
        if (result == 1){
            out.print("<font style='color:red;font-size:40px;'>User deleted</font>");
            resp.sendRedirect("/Exam/find");
        }else{
            out.print("<font style='color:red;font-size:40px;'>Failed to delete user</font>");
        }
    }
}
