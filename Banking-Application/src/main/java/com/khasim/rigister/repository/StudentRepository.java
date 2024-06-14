package com.khasim.rigister.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.khasim.rigister.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    public Student findByEmail(String username);

   
}
