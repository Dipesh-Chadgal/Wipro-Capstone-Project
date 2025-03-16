package com.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	/*
	 * 
	 * Blog-Related Exceptions 
	 * 
	 * BlogNotFoundException → Thrown when trying to fetch, update, or delete a blog that doesn't exist.
	 * InvalidBlogDataException → Thrown when blog title or content is missing or doesn't meet validation criteria.
	 * 
	 * 
	 * Comment-Related Exceptions 
	 * 
	 * CommentNotFoundException → If a comment is requested but doesn't exist.
	 * InvalidCommentDataException → If the comment text is missing or doesn't meet length constraints.
	 * 
	 * 
	 * Generic Exceptions 
	 * 
	 * InvalidRequestException → If the request body has missing or incorrect fields. 
	 * DatabaseOperationException → For unexpected database failures.
	 * 
	 */

}
