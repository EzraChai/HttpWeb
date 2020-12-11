package com.bjpowernode;

import static org.junit.Assert.assertTrue;

import com.bjpowernode.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void testInsert(){
        String config = "myBatis.xml";
        Student student = new Student(1004,"Joanne Siak","joannesiak@gmail.com",16);
        try {
            InputStream in = Resources.getResourceAsStream(config);
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = builder.build(in);
            SqlSession sqlSession = factory.openSession(true);
            String sqlId = "com.bjpowernode.dao.StudentDao" + "." + "insertStudent";
            int result = sqlSession.insert(sqlId,student);
            System.out.println(result);
            Assert.assertEquals(1,result);
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
