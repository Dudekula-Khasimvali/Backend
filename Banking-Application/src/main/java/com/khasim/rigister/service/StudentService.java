package com.khasim.rigister.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khasim.rigister.entity.Student;
import com.khasim.rigister.model.StudentDetails;
import com.khasim.rigister.repository.StudentRepository;
import com.khasim.rigister.exception.ResourceNotFoundException;


@Service
public class StudentService {

	@Autowired
	StudentRepository repository;
	
	public Student createStudent(StudentDetails studentDetails) {
		
		Student student = new Student();
		student.setFullName(studentDetails.getFullName());
		student.setPhonenumber(studentDetails.getPhonenumber());
		student.setAccType(studentDetails.getAccType());
		student.setEmail(studentDetails.getEmail());
		student.setPassword(studentDetails.getPassword());


		
		return repository.save(student);
		
	}

	public List<Student> getStudent() {
		
		return repository.findAll();
	}

	public Student getByid(long id) {
		
		return repository.findById(id).get();
	}

	public Student getByEmail(String email) {
		
		return repository.findByEmail(email);
	}

	


	public Student updateResource(Long id, StudentDetails updatedResource) {
        // Retrieve the existing resource from the database
        Student existingResource = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Resource not found with ID: " + id));

        // Update the fields of the existing resource with the fields of the updated resource
        existingResource.setFullName(updatedResource.getFullName());
        existingResource.setPhonenumber(updatedResource.getPhonenumber());
        existingResource.setAccType(updatedResource.getAccType());
        existingResource.setEmail(updatedResource.getEmail());
        existingResource.setPassword(updatedResource.getPassword());


        // Save the updated resource back to the database
        return repository.save(existingResource);
    }

	public void deleteByid(long id) {
		 repository.deleteById(id);
	}
}