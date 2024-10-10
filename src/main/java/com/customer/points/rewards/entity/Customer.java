package com.customer.points.rewards.entity;

import java.util.UUID;

import org.hibernate.bytecode.internal.bytebuddy.PrivateAccessorException;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.Data;

@Entity

@Table(name = "Customer")
public class Customer {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Integer id;
private String name;
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
public Customer() {
	super();
	// TODO Auto-generated constructor stub
}
public Customer(Integer id, String name) {
	super();
	this.id = id;
	this.name = name;
}

}
