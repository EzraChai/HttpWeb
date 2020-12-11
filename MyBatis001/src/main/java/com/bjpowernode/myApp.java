package com.bjpowernode;

import com.bjpowernode.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class myApp {
    public static void main(String[] args) {
        String config = "myBatis.xml";
        try {
            InputStream in = Resources.getResourceAsStream(config);
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = builder.build(in);
            SqlSession sqlSession = factory.openSession();
            String sqlId = "com.bjpowernode.dao.StudentDao" + "." + "selectStudents";
            List<Student> studentList = sqlSession.selectList(sqlId);
            for (Student stu:studentList){
                System.out.println(stu);
            }
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
