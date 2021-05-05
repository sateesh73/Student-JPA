package io.demo.studentreguistration.exception;

import java.util.Date;

public class CustomExceptionResponse {

    private String message;
    private String description;
    private Date timestamp;

    public CustomExceptionResponse() {
    }

    public CustomExceptionResponse(String message, String description, Date timestamp) {
        this.message = message;
        this.description = description;
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDescription() {
        return description;
    }

    public Date getTimestamp() {
        return timestamp;
    }

}
