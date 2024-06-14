package com.khasim.rigister.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.khasim.rigister.entity.Student;
import com.khasim.rigister.exception.ResourceNotFoundException;
import com.khasim.rigister.model.StudentDetails;
import com.khasim.rigister.service.StudentService;

import jakarta.persistence.EntityExistsException;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/api")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/rigister")
    public ResponseEntity<?> createStudent(@RequestBody StudentDetails studentDetails) {
        try {
            Student student = studentService.createStudent(studentDetails);
            return ResponseEntity.status(HttpStatus.CREATED).body(student);
        } catch (EntityExistsException e) { // Corrected here
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

//    @GetMapping("/get")
//    public List<Student> getStudent() {
//        return studentService.getStudent();
//    }

    @GetMapping("/tocheck/{email}")
    public ResponseEntity<?> getByEmaile(@PathVariable String email) {
        Optional<Student> student = studentService.getByEmail(email);
        if (student.isPresent()) {
            return ResponseEntity.ok(student);
        } else {
            String message = "This email is not registered";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
    }

    @PutMapping("/update/{email}")
    public ResponseEntity<Student> updateStudentByEmail(@PathVariable String email, @RequestBody StudentDetails updatedDetails) {
        try {
            Student updatedStudent = studentService.updateStudentByEmail(email, updatedDetails);
            return ResponseEntity.ok(updatedStudent);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
