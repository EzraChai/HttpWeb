package com.bjpowernode;

import com.bjpowernode.dao.studentDao;
import com.bjpowernode.domain.MyStudent;
import com.bjpowernode.domain.Student;
import com.bjpowernode.utils.MyBatisUtils;
import com.bjpowernode.vo.QueryParam;
import com.bjpowernode.vo.ViewStudent;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import javax.swing.text.View;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMyBatis {
    @Test
    public void testSelectStudentByID() {
        Integer id = 1001;
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        //帅爆！！！
        studentDao dao = sqlSession.getMapper(studentDao.class);
        Student student = dao.selectStudentByID(id);
        System.out.println(student);

        sqlSession.close();
    }

    @Test
    public void testSelectMultiParam() {
        String myName = "Chloe Gan";
        int myAge = 16;
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        studentDao dao = sqlSession.getMapper(studentDao.class);
        List<Student> studentList = dao.selectMultiParam(myName, myAge);
        for (Student student : studentList) {
            System.out.println(student);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectViewStudent() {
        Integer id = 1001;
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        //帅爆！！！
        studentDao dao = sqlSession.getMapper(studentDao.class);
        ViewStudent student = dao.selectStudentReturnViewStudent(id);
        System.out.println("1001 student = " + student);

        sqlSession.close();
    }

    @Test
    public void testCountStudent() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        studentDao dao = sqlSession.getMapper(studentDao.class);
        int result = dao.countStudent();
        System.out.println("Students' count = " + result);
    }

    @Test
    public void testSelectMap() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        studentDao dao = sqlSession.getMapper(studentDao.class);
        Map<Object, Object> map = dao.selectMapById(1001);
        System.out.println(map);
    }

    @Test
    public void testSelectAllStudents() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        studentDao dao = sqlSession.getMapper(studentDao.class);
        List<Student> studentList = dao.selectAllStudents();
        for (Student student : studentList) {
            System.out.println(student);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectAllMyStudents() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        studentDao dao = sqlSession.getMapper(studentDao.class);
        List<MyStudent> studentList = dao.selectAllMyStudents();
        for (MyStudent student : studentList) {
            System.out.println(student);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectDiffColProperty() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        studentDao dao = sqlSession.getMapper(studentDao.class);
        List<MyStudent> studentList = dao.selectDiffColProperty();
        for (MyStudent student : studentList) {
            System.out.println(student);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectLikeMethodOne() {
        String name = "%C%";
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        studentDao dao = sqlSession.getMapper(studentDao.class);
        List<Student> studentList = dao.selectLikeMethodOne(name);
        for (Student student : studentList) {
            System.out.println(student);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectLikeMethodTwo() {
        String name = "a";
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        studentDao dao = sqlSession.getMapper(studentDao.class);
        List<Student> studentList = dao.selectLikeMethodTwo(name);
        for (Student student : studentList) {
            System.out.println(student);
        }
        sqlSession.close();
    }
}
