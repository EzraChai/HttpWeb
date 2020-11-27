package com.controller;

import com.Entity.User;
import com.dao.userDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;


public class UserAddServlet  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        userDao userDao = new userDao();
        User user;
        int result;
        int result2 = 0;

        String username = req.getParameter("Username");
        String password = req.getParameter("Password");
        String gender = req.getParameter("Gender");
        String email = req.getParameter("Email");

        try {
            result2 = userDao.checkEmail(email,req);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        if (result2 != 0){
            resp.getWriter().println("Email taken");
        }else {

            user = new User(username, password, gender, email);
            Date start = new Date();
            result = userDao.add(user,req);
            Date end = new Date();
            System.out.println((end.getTime() - start.getTime())+ "milliseconds");

            if (result != 0) {
                resp.getWriter().println("Register Complete");
                resp.sendRedirect("RegisterComplete.html");
            } else {
                resp.getWriter().println("Register Failed");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
