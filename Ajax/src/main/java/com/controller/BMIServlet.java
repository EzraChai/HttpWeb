package com.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BMIServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name, weight, height;

        name = req.getParameter("Name");
        weight = req.getParameter("Weight");
        height = req.getParameter("Height");

        float heighth = Float.parseFloat(height);
        float h = heighth / 100;
        float w = Float.parseFloat(weight);
        float bmi = w / (h * h);

        String msg = "";
        if (bmi <= 18.5) {
            msg = "You are too skinny.";
        } else if (bmi <= 23.9) {
            msg = "You are normal.";
        } else if (bmi <= 27) {
            msg = "You are slightly fat.";
        } else {
            msg = "You are fat.";
        }

        msg = ("Hey [" + name + "], your BMI is " + bmi + ", " + msg);

        req.setAttribute("msg", msg);
        req.getRequestDispatcher("/result.jsp").forward(req, resp);
    }
}
