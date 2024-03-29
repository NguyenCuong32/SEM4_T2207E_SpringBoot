package com.fai.universitydemo.university.demo.dao;

import com.fai.universitydemo.university.demo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class StudentDAO implements IStudentDAO {

    private final EntityManager entityManager;
    @Autowired
    public StudentDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public List<Student> getStudents() {
        return null;
    }

    @Override
    public Student getStudentById(Integer id) {
        return entityManager.find(Student.class,id);
    }
}
