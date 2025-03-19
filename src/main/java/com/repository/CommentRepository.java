package com.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.entity.CommentEntity;

/**
 * Repository interface for managing {@link CommentEntity} operations in the database.
 * Extends {@link JpaRepository} to provide CRUD functionality.
 */
@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Long> {

    /**
     * Retrieves a list of comments associated with a specific blog.
     * 
     * @param blogId The ID of the blog.
     * @return A list of {@link CommentEntity} linked to the given blog.
     */
    List<CommentEntity> findByBlogId(Long blogId);

    /**
     * Fetches a comment by its ID using a Custom query.
     * 
     * @param commentId The ID of the comment.
     * @return An {@link Optional} containing the comment if found.
     */
    @Query("FROM CommentEntity c WHERE c.id = :commentId")
    Optional<CommentEntity> fetchCommentById(@Param("commentId") Long commentId);
}
