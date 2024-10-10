package com.customer.points.rewards.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.customer.points.rewards.entity.Transactions;

@Repository
public interface TransactionRepository extends CrudRepository<Transactions, Integer>{

	public List<Transactions> findAllTransactionsByCustomerId(Integer cId);
	 
}