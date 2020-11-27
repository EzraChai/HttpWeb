package com.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class OneFilter implements Filter  {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;


        String uri = req.getRequestURI();
        if (uri.indexOf("login")!= 1 || "/Exam/".equals(uri) || uri.indexOf("Regis")!= 1 ){
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        HttpSession session = req.getSession(false);

        if (session!= null){
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }else{
            req.getRequestDispatcher("loginError.html").forward(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
