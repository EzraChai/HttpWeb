package com.bjpowernode.dao;

import com.bjpowernode.domain.MyStudent;
import com.bjpowernode.domain.Student;
import com.bjpowernode.vo.QueryParam;
import com.bjpowernode.vo.ViewStudent;
import org.apache.ibatis.annotations.Param;

import javax.swing.text.View;
import java.util.List;
import java.util.Map;

public interface studentDao {
    Student selectStudentByID(Integer Id);
    List<Student> selectMultiParam(@Param("myName") String name,@Param("myAge") int age);
    ViewStudent selectStudentReturnViewStudent(@Param("sid") Integer id);
    int countStudent();
    Map<Object, Object>selectMapById(Integer id);
    List<Student> selectAllStudents();
    List<MyStudent> selectAllMyStudents();
    List<MyStudent> selectDiffColProperty();
    //like Query
    List<Student> selectLikeMethodOne(@Param("name") String name);
    List<Student> selectLikeMethodTwo(@Param("name") String name);
}