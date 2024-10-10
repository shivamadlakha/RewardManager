package com.customer.points.rewards.entity;

import jakarta.persistence.Entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Table(name = "Transaction")
public class Transactions {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String description;
	private BigDecimal amount;
	private LocalDate creation_date;
	private String rewardFlag;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	private Customer customer;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public LocalDate getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(LocalDate creation_date) {
		this.creation_date = creation_date;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getRewardFlag() {
		return rewardFlag;
	}

	public void setRewardFlag(String rewardFlag) {
		this.rewardFlag = rewardFlag;
	}

	public Transactions() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Transactions(Integer id, String description, BigDecimal amount, LocalDate creation_date, String rewardFlag,
			Customer customer) {
		super();
		this.id = id;
		this.description = description;
		this.amount = amount;
		this.creation_date = creation_date;
		this.rewardFlag = rewardFlag;
		this.customer = customer;
	}
	
	
}