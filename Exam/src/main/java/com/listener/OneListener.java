package com.listener;

import com.utils.DBUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class OneListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        DBUtil utils = new DBUtil();
        Map map = new HashMap();
        for (int i = 1; i < 21; i++) {
            try {
                Connection conn = utils.getConnection();
                System.out.println("Connection "+i+"created");
                map.put(conn,true);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        ServletContext application =  servletContextEvent.getServletContext();
        application.setAttribute("key",map);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        DBUtil utils = new DBUtil();
        ServletContext application = servletContextEvent.getServletContext();
        Map map = (Map) application.getAttribute("key");
        Iterator it = map.keySet().iterator();
        while (it.hasNext()){
            Connection conn = (Connection) it.next();
            if (conn != null){
                utils.close(conn,null,null);
            }
        }
    }
}
