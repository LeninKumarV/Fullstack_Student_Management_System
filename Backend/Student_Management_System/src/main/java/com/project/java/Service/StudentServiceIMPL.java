package com.project.java.Service;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.java.DTO.StudentDTO;
import com.project.java.DTO.StudentSaveDTO;
import com.project.java.DTO.StudentUpdateDTO;
import com.project.java.Entity.Student;
import com.project.java.StudentRepo.StudentRepo;



@Service
public class StudentServiceIMPL implements StudentService {
	@Autowired
	private StudentRepo studentrepo;

	
	@Override
	public String addStudent(StudentSaveDTO studentsavedto) {
		
		Student student=new Student(
				studentsavedto.getS_name(),
				studentsavedto.getS_department(),
				studentsavedto.getS_phone(),
				studentsavedto.getS_fees(),
				studentsavedto.getS_address()
			);
		
		studentrepo.save(student);
		return student.getS_name();
	}


	@Override
	public List<StudentDTO> getStudent() {
	
		List<Student> getStudent=studentrepo.findAll();
		List<StudentDTO> readStudent=new ArrayList<StudentDTO>();

		
		for (Student s : getStudent) {
			StudentDTO studentDTO=new StudentDTO(
						s.getId(),
						s.getS_name(),
						s.getS_department(),
						s.getS_phone(),
						s.getS_fees(),
						s.getS_address()
			);
			
			readStudent.add(studentDTO);
		}
		return readStudent;
	}


	@Override
	public String updateStudents(StudentUpdateDTO studentUpdateDTO) {
		
		if(studentrepo.existsById((int) studentUpdateDTO.getId())) {
				
			Student student=studentrepo.getById((int) studentUpdateDTO.getId());
			
			student.setS_name(studentUpdateDTO.getS_name());
			student.setS_address(studentUpdateDTO.getS_address());
			student.setS_department(studentUpdateDTO.getS_department());
			student.setS_fees(studentUpdateDTO.getS_fees());
			student.setS_phone(studentUpdateDTO.getS_phone());
			studentrepo.save(student);
		}
		
		else {
			JOptionPane.showMessageDialog(null, "The data is not exist");
		}
		return null;
	}


	@Override
	public boolean deleteStudent(int id) {
	
		if(studentrepo.existsById(id))
		{
			studentrepo.deleteById(id);
		}
		else {
			JOptionPane.showMessageDialog(null, "The value is doesn't exist");
		}
		return true;
	
	}
}
