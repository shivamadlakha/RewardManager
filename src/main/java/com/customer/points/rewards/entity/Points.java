package com.customer.points.rewards.entity;

import jakarta.persistence.Entity;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "POINTS")
@Data
@NoArgsConstructor
@AllArgsConstructor
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
	
}
