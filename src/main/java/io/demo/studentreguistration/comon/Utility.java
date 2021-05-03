package io.demo.studentreguistration.comon;

import java.net.URI;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.demo.studentreguistration.model.Student;

public class Utility {

    public Utility() {
    }
    public ResponseEntity<Object> getResponse(Student student, boolean isIdneedToAdd){
        URI location = null;
        if (isIdneedToAdd) {
            location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(student.getId()).toUri();
        } else {
            location = ServletUriComponentsBuilder.fromCurrentRequest().path("").build().toUri();
        }
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(location);
        return new ResponseEntity<>(student,responseHeaders,HttpStatus.OK);
    }

    
    
}
