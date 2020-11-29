package com.controller;

import com.Entity.Question;
import com.dao.QuestionDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class QuestionDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        QuestionDao dao = new QuestionDao();
        int result = 0;
        String questionId = req.getParameter("questionId");

        result = dao.delete(questionId,req);

        req.setAttribute("questionDelete",result);

//        if (result == 1){
//            req.setAttribute("info","Question deleted.");
//        }else {
//            req.setAttribute("info","Failed to delete question.");
//        }
        req.getRequestDispatcher("/info.jsp").forward(req,resp);
    }
}
