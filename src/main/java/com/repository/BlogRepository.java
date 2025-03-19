package com.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.entity.BlogEntity;

/**
 * Repository interface for performing database operations on the Blog entity.
 * Extends {@link JpaRepository} to provide CRUD functionality.
 */
@Repository
public interface BlogRepository extends JpaRepository<BlogEntity, Long> {

    /**
     * Retrieves a blog by its ID.
     * 
     * @param blogId The ID of the blog.
     * @return An {@link Optional} containing the blog if found, otherwise empty.
     */
    Optional<BlogEntity> getBlogById(Long blogId);

    /**
     * Fetches a blog along with its associated comments using a JPQL query.
     * Uses LEFT JOIN FETCH to load comments eagerly.
     * 
     * @param id The ID of the blog.
     * @return An {@link Optional} containing the blog with comments if found.
     */
    @Query("SELECT b FROM BlogEntity b LEFT JOIN FETCH b.comments WHERE b.id = :id")
    Optional<BlogEntity> findByIdWithComments(@Param("id") Long id);
}
