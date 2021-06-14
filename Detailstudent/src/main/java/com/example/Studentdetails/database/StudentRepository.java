package com.example.Studentdetails.database;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {
	StudentEntity findByStudentId(String studentId);
}
