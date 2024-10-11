package com.customer.points.rewards.entity;

import java.time.LocalDate;
import java.util.UUID;

import org.hibernate.bytecode.internal.bytebuddy.PrivateAccessorException;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity

@Table(name = "Customer")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Integer id;
private String name;
}
