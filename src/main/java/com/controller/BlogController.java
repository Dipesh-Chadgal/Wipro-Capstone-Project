package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.dto.BlogDTO;
import com.dto.BlogWithCommentDTO;
import com.dto.CommentDTO;
import com.service.BlogService;
import com.service.CommentService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

/**
 * Controller for managing blog-related operations.
 * <p>
 * Provides endpoints for creating, retrieving, updating, and deleting blogs, as well as handling comments on blogs.
 * </p>
 */
@RestController
@RequestMapping("/api")
@EnableAutoConfiguration
@Validated
public class BlogController {

	private final BlogService blogService;
	private final CommentService commentService;

	/**
	 * Constructor-based dependency injection for BlogService and CommentService.
	 *
	 * @param blogService    Service for blog operations.
	 * @param commentService Service for comment operations.
	 */
	@Autowired
	public BlogController(BlogService blogService, CommentService commentService) {
		this.blogService = blogService;
		this.commentService = commentService;
	}

	/**
	 * Retrieves a list of all blogs.
	 *
	 * @return ResponseEntity containing a list of {@link BlogDTO}.
	 */
	@GetMapping("/blogs")
	public ResponseEntity<List<BlogDTO>> getAllBlogs() {
		List<BlogDTO> blogList = blogService.getAllBlogs();
		if (blogList.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(blogList);
		}
		return ResponseEntity.status(HttpStatus.OK).body(blogList);
	}

	/**
	 * Creates a new blog.
	 *
	 * @param blogDto The blog data transfer object.
	 * @return ResponseEntity containing the created {@link BlogDTO}.
	 */
	@PostMapping("/blogs")
	public ResponseEntity<BlogDTO> addBlog(@Valid @RequestBody BlogDTO blogDto) {
		BlogDTO blog = blogService.createBlog(blogDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(blog);
	}

	/**
	 * Retrieves a blog by its ID.
	 *
	 * @param id The ID of the blog.
	 * @return ResponseEntity containing the requested {@link BlogDTO}.
	 */
	@GetMapping("/blogs/{id}")
	public ResponseEntity<BlogDTO> getBlogById(@PathVariable @NotNull Long id) {
		BlogDTO blog = blogService.getBlogById(id);
		return ResponseEntity.status(HttpStatus.OK).body(blog);
	}

	/**
	 * Updates an existing blog.
	 *
	 * @param blogDto The updated blog data.
	 * @param id      The ID of the blog to be updated.
	 * @return ResponseEntity containing the updated {@link BlogDTO}.
	 */
	@PutMapping("/blogs/{id}")
	public ResponseEntity<BlogDTO> updateBlog(@Valid @RequestBody BlogDTO blogDto, @PathVariable @NotNull Long id) {
		BlogDTO blog = blogService.updateBlog(id, blogDto);
		return ResponseEntity.status(HttpStatus.OK).body(blog);
	}

	/**
	 * Deletes a blog by its ID.
	 *
	 * @param id The ID of the blog to be deleted.
	 * @return ResponseEntity with a success message.
	 */
	@DeleteMapping("/blogs/{id}")
	public ResponseEntity<String> deleteBlog(@PathVariable @NotNull Long id) {
		blogService.deleteBlog(id);
		return ResponseEntity.status(HttpStatus.OK).body("Successfully Deleted");
	}

	/**
	 * Retrieves a blog along with its comments.
	 *
	 * @param id The ID of the blog.
	 * @return ResponseEntity containing the {@link BlogWithCommentDTO}.
	 */
	@GetMapping("/blogs/{id}/comment")
	public ResponseEntity<BlogWithCommentDTO> fetchBlogWithComment(@PathVariable @NotNull Long id) {
		BlogWithCommentDTO blog = blogService.fetchBlogWithComment(id);
		return ResponseEntity.status(HttpStatus.OK).body(blog);
	}

	/**
	 * Adds a comment to a blog.
	 *
	 * @param commentDto The comment data.
	 * @param id         The ID of the blog.
	 * @return ResponseEntity containing the created {@link CommentDTO}.
	 */
	@PostMapping("/blogs/{id}/comment")
	public ResponseEntity<CommentDTO> addComment(@Valid @RequestBody CommentDTO commentDto, @PathVariable Long id) {
		CommentDTO comment = commentService.createComment(id, commentDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(comment);
	}

	/**
	 * Retrieves a specific comment from a blog.
	 *
	 * @param id        The ID of the blog.
	 * @param commentId The ID of the comment.
	 * @return ResponseEntity containing the requested {@link CommentDTO}.
	 */
	@GetMapping("/blogs/{id}/comment/{commentId}")
	public ResponseEntity<CommentDTO> getComment(@PathVariable Long id, @PathVariable Long commentId) {
		CommentDTO comment = commentService.fetchComment(id, commentId);
		return ResponseEntity.status(HttpStatus.OK).body(comment);
	}
}
