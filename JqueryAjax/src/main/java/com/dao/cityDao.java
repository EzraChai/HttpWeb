package com.dao;

import com.entity.city;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class cityDao {
    public List findCity (Integer stateId) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "";
        String url = "jdbc:mysql://localhost:3306/malaysia?useTimezone=true&serverTimezone=UTC";
        String stateName = "";
        city city = new city();
        List list = new ArrayList();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, "root", "D9806f2a2b");
            sql = "select name from malaysiacity where statesId =?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, stateId);
            rs = ps.executeQuery();

            while(rs.next()) {
                stateName = rs.getString("name");
                list.add(stateName);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
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
        }
        return list;

    }
}
