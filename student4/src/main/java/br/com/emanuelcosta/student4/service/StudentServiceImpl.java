package br.com.emanuelcosta.student4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.emanuelcosta.student4.dao.StudentDAO;
import br.com.emanuelcosta.student4.entity.Student;
import jakarta.transaction.Transactional;

@Service
public class StudentServiceImpl implements StudentService {
	
	private StudentDAO studentDAO;
	
	@Autowired
	public StudentServiceImpl(StudentDAO theStudentDAO) {
		// TODO Auto-generated constructor stub
		
		studentDAO = theStudentDAO;
	}

	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		return studentDAO.findAll();
	}

	@Override
	public Student findById(int theId) {
		// TODO Auto-generated method stub
		return studentDAO.findById(theId);
	}

	@Transactional
	@Override
	public Student save(Student theStudent) {
		// TODO Auto-generated method stub
		return studentDAO.save(theStudent);
	}

	@Transactional
	@Override
	public void deletebyId(int theId) {
		// TODO Auto-generated method stub
		
		studentDAO.deleteById(theId);
		
	}

}
