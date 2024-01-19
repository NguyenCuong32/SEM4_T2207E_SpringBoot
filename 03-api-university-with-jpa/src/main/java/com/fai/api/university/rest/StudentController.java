package com.fai.api.university.rest;

import com.fai.api.university.entity.Student;
import com.fai.api.university.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/*
* Get Student
* Using @PathVariable in parameter
* */
@RestController
@RequestMapping("/api")
public class StudentController {
    private final StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public List<Student> GetAllStudents(){
        System.out.println("Get all student");
        return  studentService.getAllStudent();
    }
    @GetMapping("/student/{studentId}")
    public Optional<Student> GetStudentById(@PathVariable int studentId){
        System.out.println("Get a student");
        Optional<Student> student = studentService.getStudentById((studentId));
        if (student == null){
            throw new RuntimeException("Not found student");
        }
       return student;
    }
    @PostMapping("/student")
    public String AddNewStudent(@RequestBody Student newStudent){
        System.out.println("Add New a student");
        studentService.save(newStudent);
        return "Added new";
    }
}
