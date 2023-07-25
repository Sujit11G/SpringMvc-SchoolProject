package com.jsp.school.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.jsp.school.dto.Student;


@Component
public class StudentDao {

	@Autowired
	EntityManagerFactory entityManagerFactory;
	
	
	//================================toSave_Student_Data==============================
	
	public Student saveStudent(Student student) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		if(student!=null) {
			entityTransaction.begin();
			entityManager.persist(student);
			entityTransaction.commit();
			
			return student;
		}else {
			return null;
		}
		
		
	}
	
	//================================toFetch_All_Student_Data==============================
	public List<Student> viewAllStudent(){
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		
		String sql="SELECT s FROM Student s";
		
		Query query=entityManager.createQuery(sql); 
		
		return query.getResultList();
		
	}
	
	//================================toDelete_Student_Data==============================
	public boolean deleteStudent(int id) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
		
		
       Student student=entityManager.find(Student.class, id);
		
		entityTransaction.begin();
		entityManager.remove(student);
		entityTransaction.commit();
		
		return true;
	}
	
	//=================================toFetch_Student_ID====================================
	
	public Student getStudentID(int id) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		return entityManager.find(Student.class, id);
	}
	
	//================================toUpadate_Student_Data==============================
	
	public Student updateStudent(Student student,int id) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Student s=entityManager.find(Student.class, id);
		
		if(s!=null) {
			entityTransaction.begin();
			entityManager.merge(student);
			entityTransaction.commit();
		}
		return student;
		}
	
	
}
