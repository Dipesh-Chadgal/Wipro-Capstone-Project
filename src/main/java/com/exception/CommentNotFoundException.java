package com.exception;

/**
 * Custom exception thrown when a requested comment is not found.
 * This extends {@link RuntimeException} to allow unchecked exception handling.
 */
public class CommentNotFoundException extends RuntimeException {

    /**
     * Constructs a new CommentNotFoundException with the specified detail message.
     *
     * @param message The detail message explaining the reason for the exception.
     */
    public CommentNotFoundException(String message) {
        super(message);
    }
}
