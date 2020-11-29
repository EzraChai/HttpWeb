package com.dao;

import com.Entity.Question;
import com.utils.DBUtil;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
        } finally {
            utils.close(conn, ps, null);
        }
        return result;
    }

    public List findAllQuestions(HttpServletRequest req) {
        DBUtil utils = new DBUtil();
        String sql = "Select * from question";
        Connection conn = null;
        ResultSet rs = null;
        List list = new ArrayList();
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
            rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                Integer question = rs.getInt("questionId");
                String title = rs.getString("title");
                String optionA = rs.getString("OptionA");
                String optionB = rs.getString("OptionB");
                String optionC = rs.getString("OptionC");
                String optionD = rs.getString("OptionD");
                String answer = rs.getString("answer");
                Question question1 = new Question(question, title, optionA, optionB, optionC, optionD, answer);
                list.add(question1);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            utils.close(conn, null, rs);
        }
        return list;
    }

    public Question findByID(String questionId, HttpServletRequest req) {
        DBUtil utils = new DBUtil();
        String sql = "select * from question where questionId=?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Question question2 = null;
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
            ps.setInt(1, (Integer.valueOf(questionId)));
            rs = ps.executeQuery();
            while (rs.next()) {
                Integer question = rs.getInt("questionId");
                String title = rs.getString("title");
                String optionA = rs.getString("OptionA");
                String optionB = rs.getString("OptionB");
                String optionC = rs.getString("OptionC");
                String optionD = rs.getString("OptionD");
                String answer = rs.getString("answer");
                question2 = new Question(question, title, optionA, optionB, optionC, optionD, answer);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return question2;
    }

    public int update(Question question, HttpServletRequest req) {
        DBUtil utils = new DBUtil();
        String sql = "update question set title=?,optionA=?,optionB=?,optionC=?,optionD=?,answer=? where questionId=?";

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
            ps.setInt(7,question.getQuestionId());
            result = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            utils.close(conn, ps, null);
        }
        return result;
    }

    public int delete(String questionId, HttpServletRequest req) {
        DBUtil utils = new DBUtil();
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
        String sql = "delete from question where questionId=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(questionId));
            result = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            utils.close(conn,ps,null);
        }
        return result;
    }

    public List findRand(HttpServletRequest req) {
        DBUtil utils = new DBUtil();
        String sql = "select * from question order by rand() limit 0,4";
        Connection conn = null;
        ResultSet rs = null;
        List list = new ArrayList();
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
            rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                Integer question = rs.getInt("questionId");
                String title = rs.getString("title");
                String optionA = rs.getString("OptionA");
                String optionB = rs.getString("OptionB");
                String optionC = rs.getString("OptionC");
                String optionD = rs.getString("OptionD");
                String answer = rs.getString("answer");
                Question question1 = new Question(question, title, optionA, optionB, optionC, optionD, answer);
                list.add(question1);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            utils.close(conn, null, rs);
        }
        return list;
    }
}


