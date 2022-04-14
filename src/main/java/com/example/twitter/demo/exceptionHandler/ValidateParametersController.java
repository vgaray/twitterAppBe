package com.example.twitter.demo.exceptionHandler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.hibernate.type.descriptor.java.JdbcDateTypeDescriptor.DATE_FORMAT;

@Slf4j
@RestControllerAdvice
class ValidateParametersController extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> errors = new ArrayList<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.add(error.getField() + ": " + error.getDefaultMessage());
        }
        for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
            errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
        }

        DemoCustomError flashCustomError = new DemoCustomError(HttpStatus.BAD_REQUEST, "There was an error, check the partner", errors, LocalDateTime.now().format(DateTimeFormatter.ofPattern(DATE_FORMAT)), status.value());
        return buildResponseEntity(flashCustomError);
    }

    private ResponseEntity<Object> buildResponseEntity(DemoCustomError flashCustomError) {
        log.error("Error status={} message={} ", flashCustomError.getStatus(), flashCustomError.getMessage());
        return new ResponseEntity<>(flashCustomError, flashCustomError.getStatus());
    }
}