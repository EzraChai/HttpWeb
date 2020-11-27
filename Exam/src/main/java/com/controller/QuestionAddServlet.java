package com.controller;

import com.Entity.Question;
import com.dao.QuestionDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class QuestionAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title, optionA, optionB, optionC, optionD, answer;
        QuestionDao dao = new QuestionDao();
        Question question = null;
        int result = 0;

        title = req.getParameter("title");
        optionA = req.getParameter("optionA");
        optionB = req.getParameter("optionB");
        optionC = req.getParameter("optionC");
        optionD = req.getParameter("optionD");
        answer = req.getParameter("answer");
        question = new Question(null,title,optionA,optionB,optionC,optionD,answer);
        result = dao.add(question,req);

        if (result == 1){
            req.setAttribute("info","Question added completely.");
        }else {
            req.setAttribute("info","Failed to add question.");
        }
        req.getRequestDispatcher("/info.jsp").forward(req,resp);


    }
}
