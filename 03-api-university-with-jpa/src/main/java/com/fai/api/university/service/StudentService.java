package com.fai.api.university.service;

import com.fai.api.university.dao.IStudentRepository;
import com.fai.api.university.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements IStudentService{
    private IStudentRepository studentRepository;
    @Autowired
    public StudentService(IStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> getStudentById(int id) {
        return studentRepository.findById(id);
    }

    @Override
    @Transactional
    public void save(Student student) {
        studentRepository.save(student);
    }
}
