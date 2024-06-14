package com.khasim.rigister.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDetails {

	private String fullName;
	private String phonenumber;
	private String accType;
	private String email;
	private String password;
}
