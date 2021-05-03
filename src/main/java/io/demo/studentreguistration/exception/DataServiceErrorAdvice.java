package io.demo.studentreguistration.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class DataServiceErrorAdvice{


    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ExceptionHandler({DataNotFoundException.class})
    public void handle(DataNotFoundException e){}
    
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({GeneralException.class})
    public void handle(GeneralException e){}
}
