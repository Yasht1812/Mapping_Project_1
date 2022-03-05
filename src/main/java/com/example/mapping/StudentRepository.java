package com.example.mapping;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	Optional<Address> findByIdAndAddresses(int id , int addressId);
}
