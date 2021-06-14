package com.example.Studentdetails.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Studentdetails.model.ResponseStudentDetails;
import com.example.Studentdetails.model.Student;
import com.example.Studentdetails.service.StudentService;
import com.mysql.cj.log.Log;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/university")
public class StudentDetailsController {
	@Autowired
	private StudentService servi;
	
	@PostMapping("/studentdetails")
	public ResponseEntity<ResponseStudentDetails> getParticipantDetails(@RequestBody Student student)
	
	{
		ResponseStudentDetails response=servi.saveStudentDetails(student);
		if(response.getCourse()!=null)
		{	
			System.out.println(response);
			
		}
		return new ResponseEntity<ResponseStudentDetails>(response,HttpStatus.OK);
	}
}