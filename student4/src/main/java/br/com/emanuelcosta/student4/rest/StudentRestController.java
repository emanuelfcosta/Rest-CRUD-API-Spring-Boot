package br.com.emanuelcosta.student4.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.emanuelcosta.student4.entity.Student;
import br.com.emanuelcosta.student4.service.StudentService;

@RestController
public class StudentRestController {
	
	private StudentService studentService;

	@Autowired
	public StudentRestController(StudentService theStudentService) {
		
		studentService = theStudentService;
	}
	
	@GetMapping("/students")
	public List<Student> findAll(){
		
		return studentService.findAll();
		
	}
	
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		
		Student theStudent = studentService.findById(studentId);
		
		if(theStudent == null) {
			
			throw new RuntimeException("Student id not found - " + studentId);
		}
		
		return theStudent;
		
	}
	@PostMapping("/students")
	public Student addStudent(@RequestBody Student theStudent) {
		
		// id =0 to create a noew item...
		theStudent.setId(0);
		
		Student dbStudent = studentService.save(theStudent);
		
		return dbStudent;
	}
	
	@PutMapping("/students")
	public Student updateStudent(@RequestBody Student theStudent) {
		Student dbStudent = studentService.save(theStudent);
		
		return dbStudent;
	}
	
	@DeleteMapping("/students/{studentId}")
	public String deleteStudent(@PathVariable int studentId) {
		
		Student tempStudent = studentService.findById(studentId);
		
		if(tempStudent == null) {
			
			throw new RuntimeException("Student id not found - " + studentId);
		}
		
		studentService.deletebyId(studentId);
		
		return "Deleted student id - " + studentId;
		
	}
	
	

}
