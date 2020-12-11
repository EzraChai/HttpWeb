package com.bjpowernode.dao;

import com.bjpowernode.domain.Student;

import java.util.List;

public interface studentDao {
    List<Student> selectStudents();
    int insertStudent(Student student);
}
