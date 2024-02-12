package com.project.java.Service;

import java.util.List;

import com.project.java.DTO.StudentDTO;
import com.project.java.DTO.StudentSaveDTO;
import com.project.java.DTO.StudentUpdateDTO;

public interface StudentService {
	String addStudent(StudentSaveDTO studentsavedto);

	List<StudentDTO> getStudent();

	String updateStudents(StudentUpdateDTO studentUpdateDTO);

	boolean deleteStudent(int id);
}
