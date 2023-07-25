package com.jsp.school.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import com.jsp.school.dao.StudentDao;
import com.jsp.school.dto.Student;

@Component
public class StudentServices {

	@Autowired
	StudentDao studentDao;
	
	public Student saveStudent(Student student) {
		
		return studentDao.saveStudent(student);
	}
	
	public List<Student> viewAllStudent(){
		return studentDao.viewAllStudent();
	}
	

	public boolean deleteStudent(int id) {
		
		if(id>0) {
			return studentDao.deleteStudent(id);
		}else {
			System.out.println("Wrong ID");
			return false;
		}
	}
	
	public Student getStudent(int id) {
		
		return studentDao.getStudentID(id);
	}
	
	public Student updateStudent(int id,String name,String email) {
		Student student=studentDao.getStudentID(id);
		
		student.setName(name);
		student.setEmail(email);
		
		return studentDao.updateStudent(student, id);
	}
	
	
}
