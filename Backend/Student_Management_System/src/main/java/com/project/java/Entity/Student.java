package com.project.java.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Data
@Table(name = "STUDENTS4")
public class Student {
	@Id()
	@Column(name = "student_id" ,length = 50)
	
	//for id was auto incremented purpose
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "student_name",length = 50)
	private String s_name;
	
	@Column(name = "student_dept",length = 50)
	private String s_department;
	
	@Column(name = "student_phone",length = 12)
	private long s_phone;
	
	@Column(name = "student_fees",length = 50)
	private float s_fees;
	
	@Column(name = "student_address",length = 100)
	private String s_address;
	
	
	public Student(long id, String s_name, String s_department, long s_phone, float s_fees, String s_address) {
		this.id = id;
		this.s_name = s_name;
		this.s_department = s_department;
		this.s_phone = s_phone;
		this.s_fees = s_fees;
		this.s_address = s_address;
	}

	public Student() {
		
	}	

	public Student(String s_name, String s_department, long s_phone, float s_fees, String s_address) {
		this.s_name = s_name;
		this.s_department = s_department;
		this.s_phone = s_phone;
		this.s_fees = s_fees;
		this.s_address = s_address;
	}



	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getS_name() {
		return s_name;
	}


	public void setS_name(String s_name) {
		this.s_name = s_name;
	}


	public String getS_department() {
		return s_department;
	}


	public void setS_department(String s_department) {
		this.s_department = s_department;
	}


	public long getS_phone() {
		return s_phone;
	}


	public void setS_phone(long s_phone) {
		this.s_phone = s_phone;
	}


	public float getS_fees() {
		return s_fees;
	}


	public void setS_fees(float s_fees) {
		this.s_fees = s_fees;
	}


	public String getS_address() {
		return s_address;
	}


	public void setS_address(String s_address) {
		this.s_address = s_address;
	}


	@Override
	public String toString() {
		return "Student [id=" + id + ", s_name=" + s_name + ", s_department=" + s_department + ", s_phone=" + s_phone
				+ ", s_fees=" + s_fees + ", s_address=" + s_address + "]";
	}

}
