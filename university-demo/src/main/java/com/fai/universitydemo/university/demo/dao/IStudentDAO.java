package com.fai.universitydemo.university.demo.dao;

import com.fai.universitydemo.university.demo.entity.Student;

import java.util.List;

public interface IStudentDAO {
    void save(Student student);
    List<Student> getStudents();
    Student getStudentById(Integer id);
}
