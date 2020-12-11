package com.bjpowernode.dao.impl;

import com.bjpowernode.dao.studentDao;
import com.bjpowernode.domain.Student;
import com.bjpowernode.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StudentDaoImpl implements studentDao {
    @Override
    public List<Student> selectStudent() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        String sqlId = "com.bjpowernode.dao.studentDao.selectStudents";
        List<Student> studentList = sqlSession.selectList(sqlId);
        sqlSession.close();
        return studentList;
    }

    @Override
    public int insertStudent(Student student) {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        String sqlId = "com.bjpowernode.dao.studentDao.insertStudent";
        int result = sqlSession.insert(sqlId,student);
        sqlSession.commit();
        sqlSession.close();
        return result;
    }
}
