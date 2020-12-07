package com.dao;

import com.entity.state;

import java.sql.*;

public class stateDao {

    public String queryStateNameFindById(Integer id){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "";
        String url = "jdbc:mysql://localhost:3306/malaysia?useTimezone=true&serverTimezone=UTC";
        String name = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url,"root","D9806f2a2b");
            sql = "select name from malaysiastate where id =?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();

            if (rs.next()){
                name = rs.getString("name");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (ps != null ){
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
        return name;
    }

    public state queryStateFindById(Integer id){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "";
        String url = "jdbc:mysql://localhost:3306/malaysia?useTimezone=true&serverTimezone=UTC";
        String name = "";
        state state = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url,"root","D9806f2a2b");
            sql = "select id,name,abbreviation,capital from malaysiastate where id =?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();

            if (rs.next()){
                state = new state();
                state.setId(rs.getInt("id"));
                state.setName(rs.getString("name"));
                state.setAbbreviation(rs.getString("abbreviation"));
                state.setCapital(rs.getString("capital"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (ps != null ){
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
        return state;
    }
}
