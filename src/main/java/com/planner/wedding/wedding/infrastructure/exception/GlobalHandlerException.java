package com.planner.wedding.wedding.infrastructure.exception;

import com.planner.wedding.wedding.domain.error.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalHandlerException {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> methodArgumentNotValidException(MethodArgumentNotValidException ex, WebRequest request) {
        ErrorResponse error = buildResponse(ex.getBody().getDetail());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> notFoundException(NotFoundException ex, WebRequest request) {
        ErrorResponse error = buildResponse(ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> runtimeException(RuntimeException ex, WebRequest request) {
        ErrorResponse error = buildResponse(ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

    public ErrorResponse buildResponse(String message) {
        return new ErrorResponse(message);
    }
}
