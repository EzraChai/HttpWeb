package com.bjpowernode.dao;

import com.bjpowernode.domain.Student;

import java.util.List;

public interface studentDao {
    List<Student> selectStudent();
    int insertStudent(Student student);
}
