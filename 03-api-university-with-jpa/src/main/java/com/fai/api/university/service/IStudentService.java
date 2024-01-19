package com.fai.api.university.service;

import com.fai.api.university.entity.Student;

import java.util.List;
import java.util.Optional;

public interface IStudentService {
    List<Student> getAllStudent();
    Optional<Student> getStudentById(int id);
    void save(Student student);
}
