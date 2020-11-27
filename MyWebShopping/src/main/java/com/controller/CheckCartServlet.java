package com.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class CheckCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html;charset=utf-8");
        HttpSession session = req.getSession();
        Enumeration itemNames  = session.getAttributeNames();
        int itemNumber = 0;
        out.print("<table border = '2' align='center'>");
        out.print("<tr>");
        out.print("<td>Item name</td>");
        out.print("<td>Number</td>");
        out.print("</tr>");
        while (itemNames.hasMoreElements()){
            String itemName =(String) itemNames.nextElement();
            itemNumber = (int) session.getAttribute(itemName);
            System.out.println("Item name : " +  itemName + " Item Number : " + itemNumber);
            int  i = 0;
            while (i < itemNumber){
                out.print("<tr>");
                out.print("<td>"+itemName+"</td>");
                out.print("<td>"+itemNumber+"</td>");
                out.print("</tr>");
                i++;
            }
        }
        if (itemNumber != 0){
            out.print("<tr>");
            out.print("<td colspan='2' align='center' ><a href='#'>Checkout</a  ></td>");
            out.print("</tr>");

        }




    }
}
