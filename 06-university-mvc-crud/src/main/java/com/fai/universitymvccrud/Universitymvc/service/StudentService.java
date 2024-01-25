package com.fai.universitymvccrud.Universitymvc.service;

import com.fai.universitymvccrud.Universitymvc.dao.IStudentRepostirory;
import com.fai.universitymvccrud.Universitymvc.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements IStudentService {
    private final IStudentRepostirory studentRepostirory;

    @Autowired
    public StudentService(IStudentRepostirory studentRepostirory) {
        this.studentRepostirory = studentRepostirory;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepostirory.findAll();
    }

    @Override
    public Optional<Student> getStudentById(Integer id) {
        return studentRepostirory.findById(id);
    }

    @Override
    @Transactional
    public void addNewStudent(Student student) {
        studentRepostirory.save(student);
    }

    @Override
    public void updateStudent() {

    }

    @Override
    public void deleteStudent(Integer id) {
        studentRepostirory.deleteById(id);
    }
}
