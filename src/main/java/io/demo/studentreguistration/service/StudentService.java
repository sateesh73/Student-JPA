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

import io.demo.studentreguistration.comon.Utility;
import io.demo.studentreguistration.exception.DataNotFoundException;
import io.demo.studentreguistration.exception.GeneralException;
import io.demo.studentreguistration.model.Student;
import io.demo.studentreguistration.repository.StudentRepository;
import io.demo.studentreguistration.serviceDAO.StudentServiceDAO;

@Service
public class StudentService implements StudentServiceDAO {

    private StudentRepository studentRepository;
    private Utility utility = new Utility();

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudent() {
        try {
            return this.studentRepository.findAll();
        } catch (Exception e) {
            throw new GeneralException(e);
        }

    }

    @Override
    public ResponseEntity<Object> getStudent(Long id) {
        try {
            Optional<Student> student = studentRepository.findById(id);
            if (student.isPresent()) {
                return utility.getResponse(student.get(), false);
            } else
                throw new DataNotFoundException(id);
        } catch (Exception e) {
            throw new GeneralException(e);
        }
    }

    @Override
    public ResponseEntity<Object> createStudent(List<Student> student) {
        try {
            this.studentRepository.saveAll(student);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception exception) {
            throw new GeneralException(exception);
        }

    }

    @Override
    public ResponseEntity<Object> deleteStudent(Long id) {
        if (id != null) {
            this.studentRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else
            throw new DataNotFoundException(id);
    }

    @Override
    @Transactional
    public ResponseEntity<Object> updateStudent(Student student, Long id) {
        try {
            if (studentRepository.findById(id).isPresent()) {
                Student existingStudent = studentRepository.findById(id).get();
                existingStudent.setName(student.getName());
                existingStudent.setAddress(student.getAddress());
                existingStudent.setMobileNumber(student.getMobileNumber());
                student = this.studentRepository.save(existingStudent);
                return utility.getResponse(student, false);
            } else {
                throw new DataNotFoundException(id);
            }
        } catch (Exception e) {
            throw new GeneralException(e);
        }
    }

    @Override
    public ResponseEntity<Object> createOneStudent(Student student) {
        try {
            student = this.studentRepository.save(student);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(student.getId()).toUri();
            HttpHeaders responseHeaders = new HttpHeaders();
            responseHeaders.setLocation(location);
            return new ResponseEntity<>(student, responseHeaders, HttpStatus.CREATED);
        } catch (Exception e) {
            throw new GeneralException(e);
        }
    }

}
