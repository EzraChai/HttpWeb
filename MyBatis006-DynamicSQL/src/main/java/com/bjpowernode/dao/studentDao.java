package com.bjpowernode.dao;

import com.bjpowernode.domain.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface studentDao {
    List<Student> selectStudentIf(Student student);
    List<Student> selectStudentWhere(Student student);
    List<Student> selectStudentsForEach(List<Integer> idList);
    List<Student> selectStudentsForEachMethod2(List<Student> idList);
}