package com.khasim.rigister.entity;

import java.util.Date;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Rigistration")
public class Student {

	private String fistName;
	private String lastName;
	private String contact;
	@Id
	private String email;
	private String password;
	private String gender;
	@CreatedDate
	private Date createdAt;
	@CreatedBy
	private String createdBy;
}