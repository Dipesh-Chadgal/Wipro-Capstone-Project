package com.dto;

import org.hibernate.validator.constraints.Length;
import jakarta.validation.constraints.NotBlank;

/**
 * Data Transfer Object (DTO) for handling comment-related data.
 * This class is used to transfer comment information between different layers
 * of the application while ensuring validation constraints.
 */
public class CommentDTO {

    private Long id;

    /**
     * The text content of the comment.
     * <p>
     * Constraints:
     * - Cannot be blank.
     * - Must be between 3 and 200 characters.
     */
    @NotBlank
    @Length(min = 3, max = 200, message = "Comment Length Must be between 3 to 200 Characters")
    private String comment;

    /**
     * The ID of the blog to which this comment belongs.
     * This helps associate a comment with a specific blog post.
     */
    private Long blogId;

    /**
     * Getter and Setter methods for CommentDTO properties.
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }
}
