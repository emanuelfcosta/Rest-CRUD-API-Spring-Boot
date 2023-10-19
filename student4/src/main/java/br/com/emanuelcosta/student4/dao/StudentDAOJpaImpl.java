package br.com.emanuelcosta.student4.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.emanuelcosta.student4.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class StudentDAOJpaImpl implements StudentDAO {
	
	private EntityManager entityManager;
	
	@Autowired
	public StudentDAOJpaImpl(EntityManager theEntityManager) {
		
		entityManager = theEntityManager;
		
	}
	
	

	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		
		TypedQuery<Student> theQuery = entityManager.createQuery("from Student", Student.class);
		
		List<Student> students = theQuery.getResultList();
		
		return students;
	}



	@Override
	public Student findById(int theId) {
		// TODO Auto-generated method stub
		
		Student theStudent = entityManager.find(Student.class, theId);
		
		return theStudent;
	}



	@Override
	public Student save(Student theStudent) {
		// TODO Auto-generated method stub
		Student dbStudent = entityManager.merge(theStudent);
		
		return dbStudent;
	}



	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		
		Student theStudent = entityManager.find(Student.class, theId);
		
		entityManager.remove(theStudent);
		
	}
	
	
	

}
