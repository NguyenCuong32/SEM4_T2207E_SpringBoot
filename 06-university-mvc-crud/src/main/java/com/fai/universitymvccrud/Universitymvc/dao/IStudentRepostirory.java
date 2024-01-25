package com.fai.universitymvccrud.Universitymvc.dao;

import com.fai.universitymvccrud.Universitymvc.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentRepostirory extends JpaRepository<Student,Integer> {

}
