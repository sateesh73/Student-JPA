package io.demo.studentreguistration.service;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.demo.studentreguistration.comon.StudentUtility;
import io.demo.studentreguistration.exception.DataNotFoundException;
import io.demo.studentreguistration.exception.GeneralException;
import io.demo.studentreguistration.model.Student;
import io.demo.studentreguistration.repository.StudentRepository;
import io.demo.studentreguistration.serviceDAO.StudentServiceDAO;

@Service
public class StudentService implements StudentServiceDAO {

    private StudentRepository studentRepository;
    private StudentUtility utility = new StudentUtility();

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public ResponseEntity<List<Student>> getAllStudent() {
        List<Student> student = this.studentRepository.findAll();
        if (student != null) {
            return utility.getListResponse(student);
        } else {
            throw new DataNotFoundException("No DATA for Student");
        }

    }

    @Override
    public ResponseEntity<Student> getStudent(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) {
            return utility.getStudentResponse(student.get(), HttpStatus.OK, false);
        } else
            throw new DataNotFoundException("id- " + id);
    }

    @Override
    public ResponseEntity<Student> createStudents(List<Student> student) {
        try {
            this.studentRepository.saveAll(student);
            return utility.getResponse(null, HttpStatus.OK, false);
        } catch (Exception e) {
            throw new GeneralException("error found: " + e.getMessage());
        }

    }

    @Override
    public ResponseEntity<Student> deleteStudent(Long id) {
        if (id != null) {
            this.studentRepository.deleteById(id);
            return utility.getResponse(id, HttpStatus.NO_CONTENT, false);
        } else
            throw new DataNotFoundException("id- " + id);

    }

    @Override
    @Transactional
    public ResponseEntity<Student> updateStudent(Student student, Long id) {
        if (studentRepository.findById(id).isPresent()) {
            Student existingStudent = studentRepository.findById(id).get();
            existingStudent.setName(student.getName());
            existingStudent.setAddress(student.getAddress());
            existingStudent.setMobileNumber(student.getMobileNumber());
            student = this.studentRepository.save(existingStudent);
            return utility.getResponse(id, HttpStatus.OK, false);
        } else {
            throw new DataNotFoundException("id- " + id);
        }
    }

    @Override
    public ResponseEntity<Student> createStudent(Student student) {
        if (student != null) {
            student = this.studentRepository.save(student);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("s").build().toUri();
            HttpHeaders responseHeaders = new HttpHeaders();
            responseHeaders.setLocation(location);
            return new ResponseEntity<>(student, responseHeaders, HttpStatus.CREATED);

        } else {
            throw new DataNotFoundException("No DATA for Student");
        }

    }

}
