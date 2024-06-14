package com.khasim.rigister.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDetails {

	private String fistName;
	private String lastName;
	private String contact;
	private String email;
	private String password;
	private String gender;
}
