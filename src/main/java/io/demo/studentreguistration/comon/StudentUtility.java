package io.demo.studentreguistration.comon;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.demo.studentreguistration.model.Student;
public class StudentUtility {

    public StudentUtility() {
    }
    public ResponseEntity<Student> getStudentResponse(Student student, HttpStatus status, boolean isIdneedToAdd){
        URI location = null;
        if (isIdneedToAdd) {
            location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(student.getId()).toUri();
        } else {
            location = ServletUriComponentsBuilder.fromCurrentRequest().path("").build().toUri();
        }
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(location);
        return new ResponseEntity<>(student ,responseHeaders, status);
    }

    public ResponseEntity<List<Student>> getListResponse(List<Student> students){
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("").build().toUri();
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(location);
        return ResponseEntity.of(Optional.of(students));
    }

    public ResponseEntity<Student> getResponse(Long id, HttpStatus status, boolean isIdneedToAdd){
        URI location = null;
        if (isIdneedToAdd) {
            location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
        } else {
            location = ServletUriComponentsBuilder.fromCurrentRequest().path("").build().toUri();
        }
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(location);
        return ResponseEntity.status(status).headers(responseHeaders).build();
    }
    
    
}
