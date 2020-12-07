package com.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class BMIAjaxServlet extends HttpServlet {
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

        String message = "Hi ["+name+"], your BMI is "+bmi+".";

        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter printWriter = resp.getWriter();

        printWriter.println(message);
        printWriter.println(msg);
        printWriter.flush();
        printWriter.close();
    }
}
