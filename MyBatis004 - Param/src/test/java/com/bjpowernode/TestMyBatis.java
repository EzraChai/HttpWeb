package com.bjpowernode;

import com.bjpowernode.dao.studentDao;
import com.bjpowernode.domain.Student;
import com.bjpowernode.utils.MyBatisUtils;
import com.bjpowernode.vo.QueryParam;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

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
    public void testSelectMultiParam(){
        String myName = "Chloe Gan";
        int myAge = 16;
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        studentDao dao = sqlSession.getMapper(studentDao.class);
        List<Student> studentList =  dao.selectMultiParam(myName,myAge);
        for (Student student : studentList){
            System.out.println(student);
        }
        sqlSession.close();
    }
    @Test
    public void testSelectMultiObject(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        studentDao dao = sqlSession.getMapper(studentDao.class);

        QueryParam param = new QueryParam();
        param.setParamName("Chloe Gan");
        param.setParamAge(16);
        List<Student> studentList =  dao.selectMultiObject(param);
        for (Student student : studentList){
            System.out.println(student);
        }
        sqlSession.close();
    }
    @Test
    public void testSelectMultiStudent(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        studentDao dao = sqlSession.getMapper(studentDao.class);

        Student student = new Student();
        student.setName("Chloe Gan");
        student.setId(1001);
        List<Student> studentList =  dao.selectMultiStudent(student);
        for (Student students : studentList){
            System.out.println(students);
        }
        sqlSession.close();
    }
    @Test
    public void testSelectMultiStudentByMap(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        studentDao dao = sqlSession.getMapper(studentDao.class);

        Map<String,Object> data = new HashMap<>();
        data.put("myName","Chloe Gan");
        data.put("myAge","15");
        List<Student> studentList = dao.selectMultiStudentByMap(data);
        for (Student students : studentList){
            System.out.println(students);
        }
        sqlSession.close();
    }
    @Test
    public void testSelectUse$OrderBy(){
        String colName = "name";
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        studentDao dao = sqlSession.getMapper(studentDao.class);
        List<Student> studentList = dao.selectUse$Order(colName);
        for (Student students : studentList){
            System.out.println(students);
        }
        sqlSession.close();
    }
}
