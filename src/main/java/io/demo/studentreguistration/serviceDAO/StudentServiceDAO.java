package io.demo.studentreguistration.serviceDAO;

import java.util.List;

import org.springframework.http.ResponseEntity;

import io.demo.studentreguistration.model.Student;

public interface StudentServiceDAO {

    public ResponseEntity<List<Student>> getAllStudent();

    public ResponseEntity<Student> getStudent(Long id);

    public ResponseEntity<Student> createStudents(List<Student> student);

    public ResponseEntity<Student> deleteStudent(Long id);

    public ResponseEntity<Student> updateStudent(Student student, Long id);

    public ResponseEntity<Student> createStudent(Student student);

}
