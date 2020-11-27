package com.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class TwoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.
        Enumeration parameterNames = req.getParameterNames();
        while (parameterNames.hasMoreElements()){
            String parameterName = (String) parameterNames.nextElement();
            String value = req.getParameter(parameterName);
            System.out.println("Parameter name = "+parameterName);
            System.out.println("Parameter value = "+value);
        }
    }
}
