package com.controller;

import com.entity.Dept;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        Dept dept = new Dept(10,"人寿保险","Damansara");
        Gson gson = new Gson();

        String Json = gson.toJson(dept);

        req.setAttribute("key",Json);
        req.getRequestDispatcher("/index.jsp").forward(req,resp);

    }
}
