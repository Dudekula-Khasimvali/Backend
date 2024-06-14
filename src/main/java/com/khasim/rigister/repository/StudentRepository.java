package com.khasim.rigister.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.khasim.rigister.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {

    public Optional<Student> findByEmail(String username);

   
}
