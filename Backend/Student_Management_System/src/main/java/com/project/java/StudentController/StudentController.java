package com.project.java.StudentController;

import java.util.List;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.java.DTO.StudentDTO;
import com.project.java.DTO.StudentSaveDTO;
import com.project.java.DTO.StudentUpdateDTO;
import com.project.java.Service.StudentService;



@RestController
//usage -> cross origin is connect the frontend section 
@CrossOrigin()
@RequestMapping(path = "api/v1/student")
public class StudentController {
	@Autowired
	//creating Object
	private StudentService studentservice;
	
	@PostMapping(path = "/save")
	public String saveStudent(@RequestBody StudentSaveDTO studentsavedto) {
	
		String id=studentservice.addStudent(studentsavedto);
		return id;	
	}
	
	@GetMapping(path = "/read")
	public List<StudentDTO> update(){
		
		List<StudentDTO> readStudent=studentservice.getStudent();
		return readStudent;
	}
	
	
	@PutMapping(path = "/update")
	public String updateStudent(@RequestBody StudentUpdateDTO studentUpdateDTO) {
		
		String id=studentservice.updateStudents(studentUpdateDTO);
		return id;
	}
	
	@DeleteMapping(path = "/delete/{id}")
	public boolean deleteStudent(@PathVariable(value = "id") int id) {
		
		boolean del=studentservice.deleteStudent(id);
		return true;	
	}
	
	
	
}

