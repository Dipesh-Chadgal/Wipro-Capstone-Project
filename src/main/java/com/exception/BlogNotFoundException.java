package com.exception;

/**
 * Custom exception thrown when a requested blog is not found.
 * This extends {@link RuntimeException} to allow unchecked exception handling.
 */
public class BlogNotFoundException extends RuntimeException {

    /**
     * Constructs a new BlogNotFoundException with the specified detail message.
     *
     * @param message The detail message explaining the reason for the exception.
     */
    public BlogNotFoundException(String message) {
        super(message);
    }
}
