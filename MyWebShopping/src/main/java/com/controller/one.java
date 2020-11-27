package com.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class one extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String item;
        item = req.getParameter("itemName");

        HttpSession session = req.getSession();

        Integer itemNumber = (Integer) session.getAttribute(item);
        if (itemNumber == null) {
            session.setAttribute(item, 1);
        } else {
            session.setAttribute(item, itemNumber + 1);
        }
        resp.sendRedirect("/MyWebShopping");
    }
}
