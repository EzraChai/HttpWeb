package com.bjpowernode;

import com.bjpowernode.dao.studentDao;
import com.bjpowernode.domain.Student;
import com.bjpowernode.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TestMyBatis {
    @Test
    public void testSelectStudentIf() {
        Student student  = new Student();
        student.setName("Chloe Gan");
        //student.setAge(16);
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        //帅爆！！！
        studentDao dao = sqlSession.getMapper(studentDao.class);
        List<Student> studentList =  dao.selectStudentIf(student);
        for (Student students : studentList){
            System.out.println(students);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectStudentWhere() {
        Student student  = new Student();
        //student.setName("Chloe Gan");
        student.setAge(16);
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        //帅爆！！！
        studentDao dao = sqlSession.getMapper(studentDao.class);
        List<Student> studentList =  dao.selectStudentWhere(student);
        for (Student students : studentList){
            System.out.println(students);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectStudentsForEach() {
        List<Integer> idList = new ArrayList<>();
        idList.add(1001);
        idList.add(1002);
        idList.add(1003);
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        studentDao dao = sqlSession.getMapper(studentDao.class);
        List<Student> studentList =  dao.selectStudentsForEach(idList);
        for (Student students : studentList){
            System.out.println(students);
        }
        sqlSession.close();
    }
    @Test
    public void testSelectStudentsForEachMethod2() {
        List<Student> idList = new ArrayList<>();
        Student s1 = new Student();
        s1.setId(1001);
        Student s2 = new Student();
        s2.setId(1002);
        Student s3 = new Student();
        s3.setId(1003);

        idList.add(s1);
        idList.add(s2);
        idList.add(s3);

        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        studentDao dao = sqlSession.getMapper(studentDao.class);
        List<Student> studentList =  dao.selectStudentsForEachMethod2(idList);
        for (Student students : studentList){
            System.out.println(students);
        }
        sqlSession.close();
    }
}
