package com.controller;

import com.dao.cityDao;
import com.entity.city;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class cityServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String stateId = req.getParameter("id");
        System.out.println(stateId);
        cityDao dao = new cityDao();
        List list;
        ObjectMapper objectMapper = new ObjectMapper();

        list = dao.findCity(Integer.parseInt(stateId));

        String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(list);
        System.out.println(json);
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.println("{ \"name\":"+json+"}");
        out.flush();
        out.close();
    }
}
