package com.dao;

import com.Entity.Question;
import com.utils.DBUtil;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Map;

public class QuestionDao {
    public int add(Question question, HttpServletRequest req) {
        DBUtil utils = new DBUtil();

        String sql = "insert into question(title, optionA, optionB, optionC, optionD, answer) values(?,?,?,?,?,?)";

        Connection conn = null;
        PreparedStatement ps = null;
        ServletContext application = req.getSession().getServletContext();
        int result = 0;
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
            ps.setString(1, question.getTitle());
            ps.setString(2, question.getOptionA());
            ps.setString(3, question.getOptionB());
            ps.setString(4, question.getOptionC());
            ps.setString(5, question.getOptionD());
            ps.setString(6, question.getAnswer());
            result = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            utils.close(conn,ps,null);
        }
        return result;
    }
}
