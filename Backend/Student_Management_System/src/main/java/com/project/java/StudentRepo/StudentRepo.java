package com.project.java.StudentRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.project.java.Entity.Student;


@Repository
@EnableJpaRepositories
public interface StudentRepo extends JpaRepository<Student, Integer> {

}
