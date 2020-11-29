package com.controller;

import com.Entity.Question;
import com.dao.QuestionDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class QuestionFindByIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = null;
        QuestionDao dao = new QuestionDao();

        id = req.getParameter("questionId");
        Question question =  dao.findByID(id,req);
        req.setAttribute("key",question);
        req.getRequestDispatcher("/question_info.jsp").forward(req,resp);
    }
}
