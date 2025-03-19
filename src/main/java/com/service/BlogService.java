package com.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.dto.BlogDTO;
import com.dto.BlogWithCommentDTO;

/**
 * Service interface for managing blog-related operations.
 * Defines methods for CRUD operations and fetching blogs with comments.
 */
@Service
public interface BlogService {

    /**
     * Retrieves all blogs.
     * 
     * @return A list of {@link BlogDTO} representing all available blogs.
     */
    List<BlogDTO> getAllBlogs();

    /**
     * Creates a new blog entry.
     * 
     * @param blogDto The {@link BlogDTO} containing blog details.
     * @return The created {@link BlogDTO}.
     */
    BlogDTO createBlog(BlogDTO blogDto);

    /**
     * Retrieves a blog by its ID.
     * 
     * @param blogId The unique ID of the blog.
     * @return The {@link BlogDTO} representing the found blog.
     */
    BlogDTO getBlogById(Long blogId);

    /**
     * Updates an existing blog.
     * 
     * @param id The ID of the blog to update.
     * @param blogDto The {@link BlogDTO} with updated data.
     * @return The updated {@link BlogDTO}.
     */
    BlogDTO updateBlog(Long id, BlogDTO blogDto);

    /**
     * Deletes a blog by its ID.
     * 
     * @param id The ID of the blog to delete.
     */
    void deleteBlog(Long id);

    /**
     * Fetches a blog along with its associated comments.
     * 
     * @param blogId The ID of the blog.
     * @return A {@link BlogWithCommentDTO} containing blog and its comments.
     */
    BlogWithCommentDTO fetchBlogWithComment(Long blogId);
}
