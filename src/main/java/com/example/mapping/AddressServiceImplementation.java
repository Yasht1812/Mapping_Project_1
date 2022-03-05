package com.example.mapping;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImplementation implements AddressService {

	@Autowired
	AddressRepository addressRepository;
	@Autowired
	StudentRepository studentRepository;

	@Override
	public Address createAddress(int addressId, Address address) {
		return studentRepository.findById(addressId).map(student -> {
			address.setStudent(student);
			return addressRepository.save(address);
		}).orElseThrow(()-> new RuntimeException());
	}

	@Override
	public void deleteAddress(int addressId) {
		addressRepository.deleteById(addressId);

	}
	@Override
	public ResponseEntity<Object> updateStudentAndAddress(int addressId, Address address) {
		Optional<Student> student = studentRepository.findById(address.getStudent().getId());
		if (!student.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Optional<Address> address1 = addressRepository.findById(addressId);
		if (!address1.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		address.setStudent(student.get());
		address.setAddressId(address1.get().getAddressId());
		addressRepository.save(address);
		return ResponseEntity.noContent().build();
	}

}