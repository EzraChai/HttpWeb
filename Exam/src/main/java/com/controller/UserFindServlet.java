package com.controller;

import com.Entity.User;
import com.dao.userDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class UserFindServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        userDao dao = new userDao();
        PrintWriter out = resp.getWriter();
        List<User> userlist = dao.findAll();

        resp.setContentType("text/html;charset=utf-8");

        HttpSession session = req.getSession(false);
        if (session == null) {
            resp.sendRedirect("/Exam/loginError.html");
        } else {

            out.print("<table border = '2' align='center'>");
            out.print("<tr>");
            out.print("<td>User ID</td>");
            out.print("<td>Username</td>");
            out.print("<td>Password</td>");
            out.print("<td>Gender</td>");
            out.print("<td>Email</td>");
            out.print("<td>Control</td>");
            out.print("</tr>");
            for (User users : userlist) {
                out.print("<tr>");
                out.print("<td>" + users.getUserId() + "</td>");
                out.print("<td>" + users.getName() + "</td>");
                out.print("<td> ********* </td>");
                out.print("<td>" + users.getGender() + "</td>");
                out.print("<td>" + users.getEmail() + "</td>");
                out.print("<td><a href='/Exam/delete?userId=" + users.getUserId() + "'>Delete</a></td>");
                out.print("</tr>");
            }
            out.print("</table>");
        }
    }
}
