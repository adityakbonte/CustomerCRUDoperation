package com.wu.springbootdemo.MySpringBootRestApp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="Customer2")
@SequenceGenerator(name="mySequence",sequenceName="customer_sequence",initialValue=20,allocationSize=1)
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="mySequence")
	@Column(name="ID")
	private int id;
	@Column(name="FIRST_NAME")
	private String firstName;
	@Column(name="LAST_NAME")
	private String lastName;
	@Column(name="EMAIL")
	private String email;
	public Customer() {}
	public Customer(int id, String firstName, String lastName, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
