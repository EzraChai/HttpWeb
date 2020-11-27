package com.controller;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class TwoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int friedRicePrice = 10;
        int NoodlePrice = 10;
        int PizzaPrice = 20;
        int money;
        int cost = 0, balance = 0;
        String food, username = null;
        Cookie cookieArray[] = null;
        PrintWriter out = resp.getWriter();
        Cookie newCard = null;

        food = req.getParameter("food");
        System.out.println(food);
        cookieArray = req.getCookies();
        System.out.println(cookieArray);

        for (Cookie card : cookieArray) {
            String key = card.getName();
            System.out.println(key);
            String value = card.getValue();
            System.out.println(value);
            if ("username".equals(key)) {
                username = value;
            } else if ("money".equals(key)) {
                money = Integer.valueOf(value);
                balance = money;
                if ("FriedRice".equals(food)) {
                    if (friedRicePrice > money) {
                        out.println("Member : " + username);
                        out.println("You don't have enough balance.");
                    } else {
                        newCard = new Cookie("money", (money - friedRicePrice) + "");
                        cost = friedRicePrice;
                        balance = (money - friedRicePrice);
                    }
                } else if ("Noodles".equals(food)) {
                    if (NoodlePrice > money) {
                        out.println("Member : " + username);
                        out.println("You don't have enough balance.");
                    } else {
                        newCard = new Cookie("money", (money - NoodlePrice) + "");
                        cost = NoodlePrice;
                        balance = (money - NoodlePrice);
                    }
                } else if ("Pizza".equals(food)) {
                    if (PizzaPrice > money) {
                        out.println("Member : " + username);
                        out.println("You don't have enough balance.");
                    } else {
                        newCard = new Cookie("money", (money - PizzaPrice) + "");
                        cost = PizzaPrice;
                        balance = (money - PizzaPrice);
                    }
                }
            }
        }

        resp.addCookie(newCard);

        out.println("Member : " + username );
        out.println("You 've spent RM" + cost);
        out.println("Balance : " + balance);
    }
}
