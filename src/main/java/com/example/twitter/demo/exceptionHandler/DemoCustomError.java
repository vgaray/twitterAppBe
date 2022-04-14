package com.example.twitter.demo.exceptionHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.List;

@Data
public class DemoCustomError {

    private HttpStatus status;
    private int code;
    private String timestamp;
    private String message;
    private String type;
    private List<String> errors;

    public DemoCustomError(HttpStatus status, String message, List<String> errors, String timestamp, int code) {
        super();
        this.code = code;
        this.timestamp = timestamp;
        this.status = status;
        this.message = message;
        this.errors = errors;
    }

    public DemoCustomError(HttpStatus status, String message, String error, String timestamp, int code) {
        super();
        this.code = code;
        this.timestamp = timestamp;
        this.status = status;
        this.message = message;
        this.errors = Arrays.asList(error);
    }

    public DemoCustomError(HttpStatus status, String message, String error, String timestamp, int code, String type) {
        super();
        this.code = code;
        this.timestamp = timestamp;
        this.status = status;
        this.message = message;
        this.errors = Arrays.asList(error);
        this.type = type;
    }

    @Override
    @SneakyThrows
    public String toString() { return (new ObjectMapper()).writeValueAsString(this); }
}