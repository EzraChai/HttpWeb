package com.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class OneListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("Hello");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("Bye ");
    }
}
