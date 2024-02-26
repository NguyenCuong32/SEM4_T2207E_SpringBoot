package com.fai.universitymvccrud.Universitymvc.controller;

import com.fai.universitymvccrud.Universitymvc.entity.Student;
import com.fai.universitymvccrud.Universitymvc.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.io.StringBufferInputStream;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {

        this.studentService = studentService;
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
    }

    @GetMapping("/list")
    public String GetStudents(Model model) {
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "student/index";
    }

    @GetMapping("/formAdd")
    public String ShowFormAdd(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "student/addNew";
    }

    @PostMapping("/save")
    public String SaveStudent(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "student/addNew";
        } else {
            studentService.addNewStudent(student);
            return "redirect:/student/list";
        }
    }

    @GetMapping("formUpdate")
    public String ShowFormUpdate(@RequestParam("studentId") Integer id, Model model) {
        Optional<Student> student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "student/addNew";
    }

    @GetMapping("delete")
    public String DeleteStudent(@RequestParam("studentId") Integer id, Model model) {
        studentService.deleteStudent(id);
        return "redirect:/student/list";
    }
}
