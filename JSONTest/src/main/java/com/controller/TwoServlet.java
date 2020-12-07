package com.controller;

import com.entity.Dept;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TwoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Dept dept1 = new Dept(2,"社保事业部","Kuala Lumpur");
        Dept dept2 = new Dept(23,"金融事业部","Kuala Lumpur");
        Dept dept3 = new Dept(24,"公共关系事业部","Selangor");

        List deptList = new ArrayList();
        deptList.add(dept1);
        deptList.add(dept2);
        deptList.add(dept3);

        Gson gson = new Gson();
        String json =  gson.toJson(deptList);

        req.setAttribute("key",json);
        req.getRequestDispatcher("index2.jsp").forward(req,resp);
    }
}
