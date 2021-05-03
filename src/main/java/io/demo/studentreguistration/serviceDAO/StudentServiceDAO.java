package io.demo.studentreguistration.serviceDAO;

import java.util.List;

import org.springframework.http.ResponseEntity;

import io.demo.studentreguistration.model.Student;

public interface StudentServiceDAO {

    public List<Student> getAllStudent();

    public ResponseEntity<Object> getStudent(Long id);

    public ResponseEntity<Object> createStudent(List<Student> student);

    public ResponseEntity<Object> deleteStudent(Long id);

    public ResponseEntity<Object> updateStudent(Student student, Long id);
    
    public ResponseEntity<Object> createOneStudent(Student student);
    
}
