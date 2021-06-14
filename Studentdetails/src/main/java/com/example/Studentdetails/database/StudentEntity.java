package com.example.Studentdetails.database;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name="student")
public class StudentEntity {
    
		@Id
		@Column(name="id")
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int id;
		
	
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getStudentId() {
			return studentId;
		}

		public void setStudentId(String studentId) {
			this.studentId = studentId;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public String getApplicationDate() {
			return applicationDate;
		}

		public void setApplicationDate(String applicationDate) {
			this.applicationDate = applicationDate;
		}

		public String getDepartment() {
			return department;
		}

		public void setDepartment(String department) {
			this.department = department;
		}

		@Column(name="student_id")
		private String studentId;

		@Column(name="status")
		private String status;
		
		@Column(name="application_date")
		private String applicationDate;
		
		@Column(name="department")
		private String department;
		
		
		
}
