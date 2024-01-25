package com.fai.universitymvccrud.Universitymvc.service;

import com.fai.universitymvccrud.Universitymvc.entity.Student;

import java.util.List;
import java.util.Optional;

public interface IStudentService {
 List<Student> getAllStudents();
 Optional<Student> getStudentById(Integer id);
 void addNewStudent(Student student);
 void updateStudent();
 void deleteStudent(Integer id);
}
