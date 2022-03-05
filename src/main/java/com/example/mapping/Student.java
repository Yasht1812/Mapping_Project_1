package com.example.mapping;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private String bloodGroup;
	@OneToMany(mappedBy = "student",cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
	private List<Address> addresses;
	private boolean status;
	private String message;
	
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(Integer id, String name, String bloodGroup, List<Address> addresses) {
		super();
		this.id = id;
		this.name = name;
		this.bloodGroup = bloodGroup;
		this.addresses = addresses;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	@JsonManagedReference
	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", bloodGroup=" + bloodGroup + ", addresses=" + addresses + "]";
	}
	
	
}
