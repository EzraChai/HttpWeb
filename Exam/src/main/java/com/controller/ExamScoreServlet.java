package com.controller;

import com.Entity.Question;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class ExamScoreServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        List<Question> questions = null;
        int score = 0;

        questions = (List) session.getAttribute("question");

        for (Question question : questions) {
            String answer = question.getAnswer();
            Integer questionId = question.getQuestionId();
            String userAnswer = req.getParameter("answer_" + questionId);

            if (userAnswer.equals(answer)) {
                score += 25;
            }
        }
        req.setAttribute("score", "Your score : " + score + "%");
        req.getRequestDispatcher("info.jsp").forward(req, resp);

    }
}
