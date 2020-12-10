package com.controller;

import com.dao.cityDao;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class cityServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String stateId = req.getParameter("id");
        cityDao dao = new cityDao();
        ObjectMapper objectMapper = new ObjectMapper();

        List list = dao.findCity(Integer.parseInt(stateId));

        String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(list);
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.println("{ \"name\":"+json+"}");
        out.flush();
        out.close();
    }
}
