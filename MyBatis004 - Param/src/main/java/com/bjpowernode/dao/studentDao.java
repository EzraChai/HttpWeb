package com.bjpowernode.dao;

import com.bjpowernode.domain.Student;
import com.bjpowernode.vo.QueryParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface studentDao {
    Student selectStudentByID(Integer Id);
    List<Student> selectMultiParam(@Param("myName") String name,@Param("myAge") int age);
    List <Student> selectMultiObject(QueryParam param);
    List<Student> selectMultiStudent(Student student);
    List<Student> selectMultiStudentByMap(Map<String,Object> map);
    List<Student> selectUse$Order(@Param("colName")String  colName);
}