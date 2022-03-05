package com.example.mapping;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {

	@Autowired
	AddressService addressService;
	@Autowired
	StudentService studentService;

	@PostMapping("/add-student/{studentId}/add-address")
	public Address createAddress(@PathVariable(value = "studentId") int studentId, @RequestBody Address address) {
		return addressService.createAddress(studentId, address);
	}
	
	@DeleteMapping("/{addressId}")
	public void deleteAddress(@PathVariable int addressId) {
		addressService.deleteAddress(addressId);
	}
//	@PutMapping("/update-address/{id}")
	
}
