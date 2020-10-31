package com.bulimas.informationhub.exception;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public class ApiResourceExceptionDetails {

    private final String message;
    private final ZonedDateTime timeStamp;
    private final HttpStatus httpStatus;

    public ApiResourceExceptionDetails(String message, ZonedDateTime timeStamp, HttpStatus httpStatus) {
        this.message = message;
        this.timeStamp = timeStamp;
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public ZonedDateTime getTimeStamp() {
        return timeStamp;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
