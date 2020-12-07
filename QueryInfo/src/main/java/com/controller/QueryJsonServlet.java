package com.controller;

import com.dao.stateDao;
import com.entity.state;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class QueryJsonServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String json = "{}";

        if (id != null && id.trim().length() > 0 && Integer.parseInt(id) < 14 && Integer.parseInt(id) > 0) {
            stateDao dao = new stateDao();
            state st = dao.queryStateFindById(Integer.valueOf(id));
            ObjectMapper objectMapper = new ObjectMapper();
            json = objectMapper.writeValueAsString(st);
        }else{
            json = "{\"id\":"+id+",\"name\":\"No such data\",\"abbreviation\":\"No such data \",\"capital\":\"No such data\"}";
        }

        resp.setContentType("application/json;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.println(json);
        out.flush();
        out.close();
    }
}
