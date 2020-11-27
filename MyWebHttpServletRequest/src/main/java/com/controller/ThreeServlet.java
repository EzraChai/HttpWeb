package com.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class ThreeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Enumeration parameters = req.getParameterNames();
        while (parameters.hasMoreElements()){
            String parameterName = (String) parameters.nextElement();
            String value = req.getParameter(parameterName);
            System.out.println("Parameter : "+parameterName);
            System.out.println("Password : "+value);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8x");
        String username = req.getParameter("Username");
        String password = req.getParameter("Passsword");

        System.out.println("Username = " + username);
        System.out.println("Password = " + password);

    }
}
