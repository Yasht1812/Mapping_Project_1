package com.example.mapping;

import java.sql.Struct;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;

@Service
public class StudentServiceImplementation implements StudentService {

	@Autowired
	StudentRepository studentRepository;
	@Autowired
	AddressRepository addressRepository;

	@Override
	public Student createStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public ResponseEntity<Object> updateStudent(int id, Student student) {
		Optional<Student> student2 = studentRepository.findById(id);
		if (!student2.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		student.setId(id);
		studentRepository.save(student);
		return null;
	}

	@Override
	public ResponseEntity<ResponseDTO> deleteStudent(int id) {
		Optional<Student> students = studentRepository.findById(id);
		if(students.isPresent()) {
			studentRepository.deleteById(id);
			ResponseDTO responseDTO = new ResponseDTO();
			responseDTO.setMessage("Successfully deleted");
			responseDTO.setStatus(true);
			return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
	//		return new ResponseEntity<>("status : true , message: Student record for :" + students.get().getName() + " deleted successfully", HttpStatus.OK);
			
		}
		else {
			throw new RuntimeException("Error while deleting");
		}
	}

	@Override
	public List<Student> getStudent(Student student) {
		return studentRepository.findAll();
	}
	
	@Override
	public ResponseEntity<Object> deleteAddress(int id, int addressId) {
		Optional<Student> studentOptional = studentRepository.findById(id);
		if(!studentOptional.isPresent()) {
			return ResponseEntity.notFound().build() ;
		}
		addressRepository.deleteById(addressId);
		return null;
	}

}
