package com.controller;

import com.Entity.Question;
import com.dao.QuestionDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class QuestionFindServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        QuestionDao dao = new QuestionDao();

        List list = dao.findAllQuestions(req);

        req.setAttribute("key",list);
        req.getRequestDispatcher("/question.jsp").forward(req,resp);
    }
}
