package com.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class BMIServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("Name");
        String weight = req.getParameter("Weight");
        String height = req.getParameter("Height");

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

        msg = "Hi [" + name + "], your BMI is " + bmi + "." + msg;

        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.println(msg);

        writer.flush();
        writer.close();
    }
}
