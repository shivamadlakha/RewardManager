package com.customer.points.rewards.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.customer.points.rewards.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer>{

}
