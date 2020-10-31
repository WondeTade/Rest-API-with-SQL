package com.bulimas.informationhub.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiResourceExceptionHandler {

    @ExceptionHandler(value = {ApiResourceException.class})
    public ResponseEntity<Object> objectResponseEntity
            (ApiResourceException apiResourceException) {
        // Return response entity payload containing exception details
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        ApiResourceExceptionDetails exceptionDetails = new ApiResourceExceptionDetails(
                apiResourceException.getMessage(),
                ZonedDateTime.now(ZoneId.of("Z")),
                httpStatus

        );
        return new ResponseEntity<>(exceptionDetails, httpStatus);
    }

    @ExceptionHandler(value = {ApiBadRequestException.class})
    public ResponseEntity<Object> objectResponseEntity
            (ApiBadRequestException badRequestException) {
        // Return response entity payload containing exception details
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        ApiResourceExceptionDetails exceptionDetails = new ApiResourceExceptionDetails(
                badRequestException.getMessage(),
                ZonedDateTime.now(ZoneId.of("Z")),
                httpStatus

        );
        return new ResponseEntity<>(exceptionDetails, httpStatus);
    }
}
