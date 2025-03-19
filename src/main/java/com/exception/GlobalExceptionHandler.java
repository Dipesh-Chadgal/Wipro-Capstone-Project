package com.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;

/**
 * Global exception handler for handling various exceptions across the application.
 * This class provides centralized exception handling using {@link RestControllerAdvice}.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles exceptions when a blog is not found.
     *
     * @param exception The thrown {@link BlogNotFoundException}.
     * @return A response entity with an error message and HTTP status 404 (Not Found).
     */
    @ExceptionHandler(BlogNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleBlogNotFound(BlogNotFoundException exception) {
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("error", HttpStatus.NOT_FOUND.value());
        errorResponse.put("message", exception.getMessage());

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    /**
     * Handles exceptions when a comment is not found.
     *
     * @param exception The thrown {@link CommentNotFoundException}.
     * @return A response entity with an error message and HTTP status 404 (Not Found).
     */
    @ExceptionHandler(CommentNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleCommentNotFound(CommentNotFoundException exception) {
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("error", HttpStatus.NOT_FOUND.value());
        errorResponse.put("message", exception.getMessage());

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    /**
     * Handles validation errors for method arguments.
     *
     * @param exception The thrown {@link MethodArgumentNotValidException}.
     * @return A response entity with validation error details and HTTP status 400 (Bad Request).
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handle(MethodArgumentNotValidException exception) {
        List<String> details = new ArrayList<>();
        exception.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            details.add(fieldName + " | " + errorMessage);
        });
        return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);
    }

    /**
     * Handles constraint violations (e.g., invalid data formats).
     *
     * @param exception The thrown {@link ConstraintViolationException}.
     * @return A response entity with an error message and HTTP status 400 (Bad Request).
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Map<String, Object>> handleConstraintViolationException(
            ConstraintViolationException exception) {
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("error", HttpStatus.BAD_REQUEST.value());
        errorResponse.put("message", exception.getMessage());

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    /**
     * Handles unmapped URLs (when no handler is found).
     *
     * @param ex The thrown {@link NoHandlerFoundException}.
     * @param request The HTTP request object.
     * @return A response entity with details about the unmapped URL and HTTP status 404 (Not Found).
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<Map<String, Object>> handleNotFound(NoHandlerFoundException ex, HttpServletRequest request) {
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("timestamp", LocalDateTime.now());
        errorResponse.put("status", HttpStatus.NOT_FOUND.value());
        errorResponse.put("error", "Not Found");
        errorResponse.put("message", "No mapping found for " + request.getRequestURI());
        errorResponse.put("path", request.getRequestURI());

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
