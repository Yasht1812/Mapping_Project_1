package com.example.mapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

	@Autowired
	StudentService studentService;
	@Autowired
	AddressService addressService;
	
	@PostMapping("/add-student")
	public Student createStudent(@RequestBody Student student) {
		return studentService.createStudent(student);
	}
	
	@DeleteMapping("/delete-student/{id}")
	public ResponseEntity<ResponseDTO> deleteStudent(@PathVariable int id) {
		 return studentService.deleteStudent(id);	 
	}
	
	@GetMapping("/show-students")
	public List<Student> showStudents(Student student){
		return studentService.getStudent(student);
	}
	
	@PutMapping("/update-student/{id}")
	public ResponseEntity<Object> updateStudent(@PathVariable int id , @RequestBody Student student){
		return studentService.updateStudent(id, student);
	}
	
//	@DeleteMapping("/delete-student-address/{id}/address/{addressId}")
//	public ResponseEntity<Object> deleteStudentAddress(@PathVariable int id , @PathVariable int addressId,@RequestBody Address address){
//		return studentService.deleteByIdAndAddressId(id, addressId);
//	}
//	@DeleteMapping("/student/{id}/delete-address/{addressId}") 
//	public ResponseEntity<Object> deleteAddress(@PathVariable int id,@PathVariable int addressId) {
//		return studentService.deleteDetails(id,addressId);
//	}
	
	@DeleteMapping("/{id}/{addressId}")
	public ResponseEntity<Object> deleteAddress(@PathVariable int id , @PathVariable int addressId){
		return studentService.deleteAddress(id, addressId);
	}
}
