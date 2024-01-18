package com.fai.universitydemo.university.demo;

import com.fai.universitydemo.university.demo.dao.StudentDAO;
import com.fai.universitydemo.university.demo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UniversityDemoApplication {

	private final StudentDAO studentDAO;

	public static void main(String[] args) {
		SpringApplication.run(UniversityDemoApplication.class, args);
	}

	public UniversityDemoApplication(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	@Bean
	public CommandLineRunner commandLineRunner(){
		return runner->{
			System.out.println("Start Project");
//			createStudent();
			getStudentById(3);
		};
    }
	public void createStudent(){
		Student student = new Student();
		student.first_name="Ha";
		student.last_name ="Nam 123";
		student.email="cuongnx@gmail.com";
		studentDAO.save(student);
	}
	public void getStudentById(Integer id)
	{
		Student student = studentDAO.getStudentById(id);
		System.out.println(student.toString()) ;
	}
}
