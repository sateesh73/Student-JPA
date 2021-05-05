package io.demo.studentreguistration.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class DataServiceErrorAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleALLException(Exception ex, WebRequest request) throws Exception {

        CustomExceptionResponse customExceptionResponse = new CustomExceptionResponse(ex.getMessage(),
                request.getDescription(true), new Date());

        return new ResponseEntity<Object>(customExceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(DataNotFoundException.class)
    public final ResponseEntity<Object> handleNotFoundException(Exception ex, WebRequest request) throws Exception {

        CustomExceptionResponse customExceptionResponse = new CustomExceptionResponse(ex.getMessage(),
                request.getDescription(false), new Date());

        return new ResponseEntity<Object>(customExceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(GeneralException.class)
    public final ResponseEntity<Object> handleGenralException(Exception ex, WebRequest request) throws Exception {

        CustomExceptionResponse customExceptionResponse = new CustomExceptionResponse(ex.getMessage(),
                request.getDescription(true), new Date());

        return new ResponseEntity<Object>(customExceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
