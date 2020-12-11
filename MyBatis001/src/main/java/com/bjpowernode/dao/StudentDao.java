package com.bjpowernode.dao;

import com.bjpowernode.domain.Student;

import java.util.List;

public interface StudentDao {

    //查询student表的所有数据
    public List <Student> selectStudents();

    public int insertStudent(Student student);
}
