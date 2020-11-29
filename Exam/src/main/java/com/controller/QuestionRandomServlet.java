package com.controller;

import com.dao.QuestionDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class QuestionRandomServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        QuestionDao dao = new QuestionDao();
        HttpSession session = req.getSession();

        List list = dao.findRand(req);
        System.out.println(list);

        session.setAttribute("question",list);

        req.getRequestDispatcher("/exam.jsp").forward(req,resp);
    }
}
