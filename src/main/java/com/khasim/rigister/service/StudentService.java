package com.khasim.rigister.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khasim.rigister.entity.Student;
import com.khasim.rigister.exception.ResourceNotFoundException;
import com.khasim.rigister.model.StudentDetails;
import com.khasim.rigister.repository.StudentRepository;

import jakarta.persistence.EntityExistsException;

@Service
public class StudentService {

    @Autowired
    StudentRepository repository;

    public Student createStudent(StudentDetails studentDetails) {
        // Check if a student with the given email already exists
        if (repository.findByEmail(studentDetails.getEmail()).isPresent()) {
            throw new EntityExistsException("Email already registered: " + studentDetails.getEmail());
        }

        Student student = new Student();
        student.setFistName(studentDetails.getFistName());
        student.setLastName(studentDetails.getLastName());
        student.setContact(studentDetails.getContact());
        student.setEmail(studentDetails.getEmail());
        student.setPassword(studentDetails.getPassword());
        student.setGender(studentDetails.getGender());
        student.setCreatedAt(new Date());
        student.setCreatedBy(System.getProperty("user.name"));

        return repository.save(student);
    }

    public List<Student> getStudent() {
        return repository.findAll();
    }

    public Optional<Student> getByEmail(String email) {
        return repository.findByEmail(email);
    }

    public Student updateStudentByEmail(String email, StudentDetails updatedDetails) {
        Student existingStudent = repository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with email: " + email));

        existingStudent.setFistName(updatedDetails.getFistName());
        existingStudent.setLastName(updatedDetails.getLastName());
        existingStudent.setContact(updatedDetails.getContact());
        existingStudent.setEmail(updatedDetails.getEmail());
        existingStudent.setPassword(updatedDetails.getPassword());
        existingStudent.setGender(updatedDetails.getGender());

        return repository.save(existingStudent);
    }
}
