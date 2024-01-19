package com.fai.api.university.dao;

import com.fai.api.university.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentRepository extends JpaRepository<Student,Integer> {
}
