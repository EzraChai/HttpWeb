package com.controller;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username,money;
        username = req.getParameter("name");
        money = req.getParameter("deposit");

        Cookie card1 = new Cookie("username", username);
        Cookie card2 = new Cookie("money", money);

        resp.addCookie(card1);
        resp.addCookie(card2);

        req.getRequestDispatcher("/index-2.html").forward(req,resp);
    }
}
