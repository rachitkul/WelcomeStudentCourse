package com.example.Studentdetails.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Studentdetails.database.StudentEntity;
import com.example.Studentdetails.database.StudentRepository;
import com.example.Studentdetails.model.ResponseStudentDetails;
import com.example.Studentdetails.model.Student;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	
	public ResponseStudentDetails saveStudentDetails(Student studentPojo) {
  		
		StudentEntity studentEntityOriginal=studentRepository.findByStudentId(studentPojo.getStudentId());
		StudentEntity studentEntity=new StudentEntity();
		if(studentEntityOriginal!=null)
		{
			studentEntityOriginal.setDepartment(studentPojo.getDepartment());
			studentRepository.save(studentEntityOriginal);
			
		}
		else
		{
     	
     	studentEntity.setStudentId(studentPojo.getStudentId());
     	studentEntity.setApplicationDate(studentPojo.getApplicationDate());
     	studentEntity.setDepartment(studentPojo.getDepartment());
     	studentEntity.setStatus(studentPojo.getStatus());
     	studentEntityOriginal=studentRepository.save(studentEntity);
		}
     	
     	
     	ResponseStudentDetails responseStudentDetails=new ResponseStudentDetails();
     	if(studentPojo.getDepartment()!=null)
     	{
     		if(studentPojo.getDepartment().equalsIgnoreCase("Business"))
     		{
     			responseStudentDetails.setCourse("BUS1010");
     		}
     		else if(studentPojo.getDepartment().equalsIgnoreCase("Engineering"))
     		{
     			responseStudentDetails.setCourse("ENG1010");
     		}
     		else if(studentPojo.getDepartment().equalsIgnoreCase("Arts and Sciences"))
     		{
     			responseStudentDetails.setCourse("SCI1010");
     		}
     	}
     	responseStudentDetails.setStudentID(studentEntityOriginal.getStudentId());
     	responseStudentDetails.setStatus(studentEntityOriginal.getStatus());
     	responseStudentDetails.setDepartment(studentEntityOriginal.getDepartment());
     	responseStudentDetails.setTimestamp(studentEntityOriginal.getApplicationDate());
     	 return responseStudentDetails;
     	    
     
  		
  	}
}
