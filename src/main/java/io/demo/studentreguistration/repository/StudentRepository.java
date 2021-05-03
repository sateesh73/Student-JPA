package io.demo.studentreguistration.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.demo.studentreguistration.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    
}
