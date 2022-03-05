package com.example.mapping;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface StudentService {

	Student createStudent(Student student);
	
	ResponseEntity<Object> updateStudent(int id , Student student);
	
	ResponseEntity<ResponseDTO> deleteStudent(int id);
	
	ResponseEntity<Object> deleteAddress(int id , int addressId);
	
	List<Student> getStudent(Student student);

	
}
