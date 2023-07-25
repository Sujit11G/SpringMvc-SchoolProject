package com.jsp.school.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.school.dto.Student;
import com.jsp.school.services.StudentServices;

@Controller
public class StudentController {

	@Autowired
	StudentServices studentServices;
	
	
	@RequestMapping("/studentload")
	public ModelAndView studentLoad() {
	
		ModelAndView modelAndView=new ModelAndView("studentform.jsp");
		
		modelAndView.addObject("student1", new Student());
		
		return modelAndView;
	}
	
	@PostMapping("/studentadd")
	public ModelAndView saveStudent(@ModelAttribute Student student) {
		
		ModelAndView modelAndView=new ModelAndView("home.jsp");
		
		Student student2=studentServices.saveStudent(student);
		 modelAndView.addObject("saved", student2.getName()+" saved Successfully");
		
		return modelAndView;
	} 
	
	@GetMapping("/viewAllStudent")
	public ModelAndView viewAllStudent() {
		
		ModelAndView modelAndView=new ModelAndView("viewAll.jsp");
		
		List<Student> students=studentServices.viewAllStudent();
		modelAndView.addObject("students", students);
		
		return modelAndView;
	}
	
	@RequestMapping("/delete")
	public ModelAndView deleteStudentByID(@RequestParam(name="id")int id ){
		
		boolean b=studentServices.deleteStudent(id);
		
		ModelAndView modelAndView=new ModelAndView("viewAll.jsp");
			
		if (b==true) {
	        List<Student> students = studentServices.viewAllStudent();
	        modelAndView.addObject("students", students);
	    } 
			return modelAndView;
		
	}
	
	@GetMapping("/update")
	public ModelAndView updateStudentForm(@RequestParam(name="id")int id) {
		//Student student=studentServices.getStudent(id);
		
		ModelAndView modelAndView=new ModelAndView("update.jsp");
		
		modelAndView.addObject("updateStudent",studentServices.getStudent(id));
		
		return modelAndView;	
	}
	
	@RequestMapping("/studentupdate")
	public ModelAndView updateStudentID(@ModelAttribute  Student student) {
		
		Student s=studentServices.updateStudent(student.getId(),student.getName(),student.getEmail()); 
		
		ModelAndView modelAndView=new ModelAndView("viewAll.jsp");
		List<Student> students=studentServices.viewAllStudent();
		modelAndView.addObject("students", students);

	//	modelAndView.addObject("students", s.getName()+" saved Successfully" );
		
		return modelAndView;
	}
	
//public ModelAndView updateStudent() {
//		
//		ModelAndView modelAndView=new ModelAndView("viewAll.jsp");
//		
//		
//		modelAndView.addObject("students", studentServices.viewAllStudent() );
//		
//		return modelAndView;
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
