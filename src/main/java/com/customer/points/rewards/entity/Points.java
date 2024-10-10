package com.customer.points.rewards.entity;

import jakarta.persistence.Entity;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Table(name = "POINTS")
public class Points {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private int rewards;
	private LocalDate point_date;
	
	@ManyToOne
	private Customer customer;
	@OneToOne
	private Transactions transactions;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getRewards() {
		return rewards;
	}
	public void setRewards(int rewards) {
		this.rewards = rewards;
	}
	public LocalDate getPoint_date() {
		return point_date;
	}
	public void setPoint_date(LocalDate point_date) {
		this.point_date = point_date;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Transactions getTransactions() {
		return transactions;
	}
	public void setTransactions(Transactions transactions) {
		this.transactions = transactions;
	}
	public Points() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Points(Integer id, int rewards, LocalDate point_date, Customer customer, Transactions transactions) {
		super();
		this.id = id;
		this.rewards = rewards;
		this.point_date = point_date;
		this.customer = customer;
		this.transactions = transactions;
	}
	
}
