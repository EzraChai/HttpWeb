package com.bjpowernode;

import com.bjpowernode.dao.impl.StudentDaoImpl;
import com.bjpowernode.dao.studentDao;
import com.bjpowernode.domain.Student;
import org.junit.Test;

import java.util.List;

public class TestMyBatis {
    @Test
    public void testSelectStudents() {
        studentDao dao = new StudentDaoImpl();
        List<Student> studentList = dao.selectStudent();
        for (Student student : studentList){
            System.out.println(student);
        }
    }
    @Test
    public void testInsert(){
        Student student = new Student(1005,"Yeng Ming Ching","mingching@gmail.com",15);
        studentDao dao = new StudentDaoImpl();
        int num = dao.insertStudent(student);
        System.out.println("Insert Count = " + num);
    }
}
