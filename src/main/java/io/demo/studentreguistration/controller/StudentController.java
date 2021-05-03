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
    public ResponseEntity<List<Student>> getStudents() {
        return this.studentService.getAllStudent();
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable String id) {
        return this.studentService.getStudent(Long.parseLong(id));
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable String id) {
        return this.studentService.updateStudent(student, Long.parseLong(id));

    }

    @PostMapping("/students")
    public ResponseEntity<Student> createStudents(@RequestBody List<Student> student) {
        return this.studentService.createStudents(student);
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable String id) {
        return this.studentService.deleteStudent(Long.parseLong(id));
    }

    @PostMapping("/student")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        return this.studentService.createStudent(student);
    }
}
