package com.controller;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
           ServletContext servletContext = req.getServletContext();
        servletContext.setAttribute("key1", 100);
        servletContext.setAttribute("key1", 920);
        servletContext.removeAttribute("key1");
    }
}
