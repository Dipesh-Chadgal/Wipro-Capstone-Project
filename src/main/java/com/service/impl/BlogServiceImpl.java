package com.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.BlogDTO;
import com.dto.BlogWithCommentDTO;
import com.entity.BlogEntity;
import com.exception.BlogNotFoundException;
import com.mapper.BlogMapper;
import com.repository.BlogRepository;
import com.service.BlogService;

/**
 * Implementation of {@link BlogService} to handle blog-related operations.
 * Provides CRUD functionality and fetching blogs with comments.
 */
@Service
public class BlogServiceImpl implements BlogService {

    private final BlogRepository blogRepo;

    /**
     * Constructs a BlogServiceImpl with the required repository dependency.
     *
     * @param blogRepo The {@link BlogRepository} for database operations.
     */
    @Autowired
    public BlogServiceImpl(BlogRepository blogRepo) {
        this.blogRepo = blogRepo;
    }

    /**
     * Retrieves all blogs.
     *
     * @return A list of {@link BlogDTO} representing all blogs.
     */
    @Override
    public List<BlogDTO> getAllBlogs() {
        return blogRepo.findAll()
                .stream()
                .map(BlogMapper::convertToDTO)
                .collect(Collectors.toList());
    }

    /**
     * Creates a new blog.
     *
     * @param blogDto The {@link BlogDTO} containing blog details.
     * @return The created {@link BlogDTO}.
     */
    @Override
    public BlogDTO createBlog(BlogDTO blogDto) {
        BlogEntity blog = blogRepo.save(BlogMapper.convertToEntity(blogDto));
        return BlogMapper.convertToDTO(blog);
    }

    /**
     * Retrieves a blog by its ID.
     *
     * @param blogId The ID of the blog.
     * @return The corresponding {@link BlogDTO}.
     * @throws BlogNotFoundException If no blog is found with the given ID.
     */
    @Override
    public BlogDTO getBlogById(Long blogId) {
        BlogEntity blog = blogRepo.getBlogById(blogId)
                .orElseThrow(() -> new BlogNotFoundException("Blog with ID: " + blogId + " doesn't exist"));
        return BlogMapper.convertToDTO(blog);
    }

    /**
     * Updates an existing blog.
     *
     * @param id      The ID of the blog to update.
     * @param blogDto The {@link BlogDTO} containing updated details.
     * @return The updated {@link BlogDTO}.
     * @throws BlogNotFoundException If no blog is found with the given ID.
     */
    @Override
    public BlogDTO updateBlog(Long id, BlogDTO blogDto) {
        BlogEntity blog = blogRepo.getBlogById(id)
                .orElseThrow(() -> new BlogNotFoundException("No Blog Found with ID: " + id));

        blog.setTitle(blogDto.getTitle());
        blog.setContent(blogDto.getContent());
        blogRepo.save(blog);

        return BlogMapper.convertToDTO(blog);
    }

    /**
     * Deletes a blog by its ID.
     *
     * @param id The ID of the blog to delete.
     * @throws BlogNotFoundException If no blog is found with the given ID.
     */
    @Override
    public void deleteBlog(Long id) {
        BlogEntity blog = blogRepo.getBlogById(id)
                .orElseThrow(() -> new BlogNotFoundException("No Blog Found with ID: " + id));

        blogRepo.delete(blog);
    }

    /**
     * Fetches a blog along with its associated comments.
     *
     * @param blogId The ID of the blog.
     * @return The {@link BlogWithCommentDTO} containing blog details and comments.
     * @throws BlogNotFoundException If no blog is found with the given ID.
     */
    @Override
    public BlogWithCommentDTO fetchBlogWithComment(Long blogId) {
        BlogEntity blog = blogRepo.findByIdWithComments(blogId)
                .orElseThrow(() -> new BlogNotFoundException("Blog with ID: " + blogId + " doesn't exist"));

        return BlogMapper.convertToCommentDTO(blog);
    }
}
