package com.bjpowernode;

import com.bjpowernode.dao.studentDao;
import com.bjpowernode.domain.Student;
import com.bjpowernode.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class TestMyBatis {
    @Test
    public void testSelectStudents() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        //帅爆！！！
        studentDao dao = sqlSession.getMapper(studentDao.class);
        List<Student> studentList = dao.selectStudents();
        for (Student student : studentList) {
            System.out.println(student);
        }

        sqlSession.close();
    }

    @Test
    public void testInsert() {
        Student student = new Student(1006, "Andy Yee", "andyyee@gmail.com", 15);
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        studentDao dao = sqlSession.getMapper(studentDao.class);
        dao.insertStudent(student);
        sqlSession.commit();
        sqlSession.close();
    }
}
