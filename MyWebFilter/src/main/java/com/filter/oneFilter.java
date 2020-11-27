package com.filter;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class oneFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String age = servletRequest.getParameter("age");
        if (Integer.parseInt(age) < 70 && Integer.parseInt(age) > 17 ){
            filterChain.doFilter(servletRequest,servletResponse); //放行
        }else{
            servletResponse.setContentType("text/html;charset=utf-8");
            PrintWriter writer = servletResponse.getWriter();
            writer.println("<center><font style='color:red;font-size: 40px;'>You are not allow to see this picture.</font></center>");
        }
    }

    @Override
    public void destroy() {

    }
}
