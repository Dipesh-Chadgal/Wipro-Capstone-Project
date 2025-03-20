package com.service;

import com.dto.CommentDTO;

/**
 * Service interface for managing comments.
 * Defines methods for creating and retrieving comments for a blog.
 */
public interface CommentService {

    /**
     * Creates a new comment for a given blog.
     *
     * @param id The ID of the blog where the comment will be added.
     * @param commentDto The {@link CommentDTO} containing the comment details.
     * @return The created {@link CommentDTO}.
     */
    CommentDTO createComment(Long id, CommentDTO commentDto);

    /**
     * Fetches a specific comment from a blog.
     *
     * @param id The ID of the blog.
     * @param commentId The ID of the comment to fetch.
     * @return The {@link CommentDTO} representing the retrieved comment.
     */
    CommentDTO fetchComment(Long id, Long commentId);
    
    /**
     * Delete a specific comment from a blog.
     *
     * @param commentId The ID of the comment to delete.
     * @return Boolean value representing the success of the deletion.
     */
    Boolean deleteComment(Long commentId, Long blogId);

}
