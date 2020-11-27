package com.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url =  req.getRequestURL().toString();
        String method = req.getMethod();

        String uri = req.getRequestURI();

        resp.getWriter().println("Url : "+url);
        resp.getWriter().println("Method : "+method);
        resp.getWriter().println("Uri : "+uri);

    }
}
