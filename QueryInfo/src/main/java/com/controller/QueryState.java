package com.controller;

import com.dao.stateDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class QueryState extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        stateDao dao = new stateDao();
        String value = "No data";
        String stateId = req.getParameter("stateId");

        if (!"".equals(stateId.trim())) {
            value = dao.queryStateNameFindById(Integer.valueOf(stateId));
            if ("".equals(value)){
                value = "No such state";
            }
        }


        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.println(value);
        out.flush();
        out.close();
    }
}
