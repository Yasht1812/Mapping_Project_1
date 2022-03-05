package com.example.mapping;

import org.springframework.http.ResponseEntity;

public interface AddressService {

	Address createAddress(int studentId,Address address);
	
	//ResponseEntity<Object> updateAddress(int id , Address address);
	
	void deleteAddress(int addressId);
	
	ResponseEntity<Object> updateStudentAndAddress (int addressId, Address address);
	
	
}
