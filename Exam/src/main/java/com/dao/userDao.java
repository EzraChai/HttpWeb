package com.dao;

import com.Entity.User;
import com.utils.DBUtil;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class userDao {

    private DBUtil util = new DBUtil();

    public int checkEmail(String email, HttpServletRequest req) throws SQLException {
        String sql = "Select * from userinfo where email = ?";
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        int size = 0;
        ServletContext application = req.getSession().getServletContext();
        Map map = (Map) application.getAttribute("key");
        for (Object o : map.keySet()) {
            conn = (Connection) o;
            boolean flag = (boolean) map.get(conn);
            if (flag) {
                map.put(conn, false);
                break;
            }
        }
        ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
//        try {
//            conn = util.getConnection();
//            ps = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,
//                    ResultSet.CONCUR_READ_ONLY);
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
        try {
            ps.setString(1, email);
            rs = ps.executeQuery();
            if (rs != null) {
                try {
                    rs.last();
                    size = rs.getRow();
                    rs.beforeFirst();
                } catch (Exception ex) {
                    return 0;
                }
                return size;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            ServletContext application2 = req.getSession().getServletContext();
            Map map2 = (Map) application2.getAttribute("key");
            map2.put(conn,true);
        }
        return size;
    }

    public int add(User user,HttpServletRequest req) {


        String sql = "INSERT into userinfo(name,password,gender,email) values (?,?,?,?)";
        Connection conn = null;
        PreparedStatement ps = null;
        ServletContext application = req.getSession().getServletContext();
        Map map = (Map) application.getAttribute("key");
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            conn = (Connection) it.next();
            boolean flag = (boolean) map.get(conn);
            if (flag) {
                map.put(conn, false);
                break;
            }
        }
        try {
            ps = conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        try {
//            conn = util.getConnection();
//            ps = conn.prepareStatement(sql);
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
        int result = 0;
        try {
            ps.setString(1, user.getName());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getGender());
            ps.setString(4, user.getEmail());
            result = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            util.close(conn, ps, null);
        }
        return result;

    }

    public List<User> findAll() {
        String sql = "select * from userinfo";
        Connection conn = null;
        try {
            conn = util.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        PreparedStatement ps = null;
        List<User> userlist = new ArrayList<>();
        try {
            ps = conn.prepareStatement(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        ResultSet rs = null;
        try {
            rs = ps.executeQuery();
            while (rs.next()) {
                Integer userid = rs.getInt("userId");
                String username = rs.getString("name");
                String password = rs.getString("password");
                String gender = rs.getString("gender");
                String email = rs.getString("email");
                User user = new User(userid, username, password, gender, email);
                userlist.add(user);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            util.close(conn, ps, rs);
        }
        return userlist;
    }

    public int delete(String userId) {
        Connection conn = null;
        try {
            conn = util.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        ;
        String sql = "delete from userinfo where userid =? ";
        int result = 0;
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, Integer.valueOf(userId));
            result = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            util.close(conn, ps, null);
        }
        return result;
    }

    public int login(String email, String password,HttpServletRequest req) {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        int result = 0;
        String sql = "select count(*)from userinfo where email = ? and password = ?";
        ServletContext application = req.getSession().getServletContext();
        Map map = (Map) application.getAttribute("key");
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            conn = (Connection) it.next();
            boolean flag = (boolean) map.get(conn);
            if (flag) {
                map.put(conn, false);
                break;
            }
        }
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while (rs.next()) {
                result += rs.getInt("count(*)");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        try {
//            conn = util.getConnection();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        try {
//            ps = conn.prepareStatement(sql);
//            ps.setString(1, email);
//            ps.setString(2, password);
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                result += rs.getInt("count(*)");
//            }
        finally {
            util.close(null,ps, rs);
        }
        return result;
    }
}
