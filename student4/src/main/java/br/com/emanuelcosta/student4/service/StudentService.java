package br.com.emanuelcosta.student4.service;

import java.util.List;

import br.com.emanuelcosta.student4.entity.Student;

public interface StudentService {
	
	List<Student> findAll();
	
	Student findById(int theId);
	
	Student save(Student theStudent);
	
	void deletebyId(int theId);

}
