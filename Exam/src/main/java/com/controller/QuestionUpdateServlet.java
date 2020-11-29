package com.controller;

import com.Entity.Question;
import com.dao.QuestionDao;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class QuestionUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String questionId,title, optionA, optionB, optionC, optionD, answer;
        int result = 0;
        QuestionDao dao = new QuestionDao();

        questionId = req.getParameter("questionId");
        title = req.getParameter("title");
        optionA = req.getParameter("optionA");
        optionB = req.getParameter("optionB");
        optionC = req.getParameter("optionC");
        optionD = req.getParameter("optionD");
        answer = req.getParameter("answer");
        Question question = new Question(Integer.valueOf(questionId), title, optionA, optionB, optionC, optionD, answer);
        result = dao.update(question,req);

        req.setAttribute("questionUpdate",result);

//        if (result == 1){
//            req.setAttribute("info","Question update completely.");
//        }else {
//            req.setAttribute("info","Failed to update question.");
//        }
        req.getRequestDispatcher("/info.jsp").forward(req,resp);
    }
}
