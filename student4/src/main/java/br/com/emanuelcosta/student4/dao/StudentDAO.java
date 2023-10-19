package br.com.emanuelcosta.student4.dao;

import java.util.List;

import br.com.emanuelcosta.student4.entity.Student;

public interface StudentDAO {
	
	List<Student> findAll();
	
	Student findById(int theId);
	
	Student save(Student theStudent);
	
	void deleteById(int theId);

}
