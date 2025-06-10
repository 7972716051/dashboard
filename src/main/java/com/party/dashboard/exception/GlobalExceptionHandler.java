package com.party.dashboard.exception;

import com.party.dashboard.model.ErrorTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<ErrorTemplate> handleDataNotFoundException(DataNotFoundException ex) {
    	   ErrorTemplate errorTemplate = new ErrorTemplate();

           errorTemplate .setMessage(ex.getMessage());
           errorTemplate.setStatusCode(HttpStatus.NOT_FOUND.name());

        return new ResponseEntity<>(errorTemplate, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DataExistException.class)
    public ResponseEntity<ErrorTemplate> handledDataExistException(DataExistException ex) {
    	   ErrorTemplate errorTemplate = new ErrorTemplate();

           errorTemplate .setMessage(ex.getMessage());
           errorTemplate.setStatusCode(HttpStatus.BAD_REQUEST.name());

        return new ResponseEntity<>(errorTemplate, HttpStatus.BAD_REQUEST);
    }
}
