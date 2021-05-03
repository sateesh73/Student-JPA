package io.demo.studentreguistration.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.demo.studentreguistration.model.Student;
import io.demo.studentreguistration.service.StudentService;

@RestController
public class StudentController {

    public StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return this.studentService.getAllStudent();
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Object> getStudent(@PathVariable String id) {
        return this.studentService.getStudent(Long.parseLong(id));
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<Object> updateStudent(@RequestBody Student student, @PathVariable String id) {
        return this.studentService.updateStudent(student, Long.parseLong(id));

    }

    @PostMapping("/students")
    public ResponseEntity<Object> createStudents(@RequestBody List<Student> student) {
        return this.studentService.createStudent(student);
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<Object> deleteStudent(@PathVariable String id) {
        return this.studentService.deleteStudent(Long.parseLong(id));
    }

    @PostMapping("/student")
    public ResponseEntity<Object> createStudent(@RequestBody Student student) {
        return this.studentService.createOneStudent(student);
    }
}
