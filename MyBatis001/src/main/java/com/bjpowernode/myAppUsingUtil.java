package com.bjpowernode;

import com.bjpowernode.domain.Student;
import com.bjpowernode.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class myAppUsingUtil {
    public static void main(String[] args){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        String sqlId = "com.bjpowernode.dao.StudentDao.selectStudents";
        List <Student> studentList = sqlSession.selectList(sqlId);
        System.out.println();
        for(Student student : studentList){
            System.out.println(student);
            sqlSession.close();
        }
    }
}
