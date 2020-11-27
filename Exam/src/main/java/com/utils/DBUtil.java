package com.utils;

import java.sql.*;

//JDBC 工具类，简化JDBC编程
public class DBUtil {
    public DBUtil() {
    }

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接对象
     *
     * @return 连接对象
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/user?useTimezone=true&serverTimezone=UTC", "root", "D9806f2a2b");
    }

    /**
     * 关闭资源
     * @param conn
     * @param ps   数据库操作对象
     *
     */
    public void close(Connection conn, Statement ps,ResultSet rs) {
        //6.释放资源
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (rs != null){
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
