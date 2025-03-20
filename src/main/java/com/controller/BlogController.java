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

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

/**
 * Controller for managing blog-related operations.
 * <p>
 * Provides End-points for creating, retrieving, updating, and deleting blogs,
 * as well as handling comments on blogs.
 * </p>
 */
@RestController
@RequestMapping("/api")
@Validated
public class BlogController {

	private BlogService blogService;
	private CommentService commentService;

	/**
	 * Constructor-based dependency injection for BlogService and CommentService.
	 *
	 * @param blogService    Service for blog operations.
	 * @param commentService Service for comment operations.
	 */
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
	@Tag(name = "Fetch all blogs ")
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
	@Tag(name = "Create a new Blog ")
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
	@Tag(name = "Fetch a blog by it's ID ")
	public ResponseEntity<BlogDTO> getBlogById(
			@PathVariable @NotNull @Positive(message = "Blogs Id should be Positive Integer") Long id) {

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
	@Tag(name = "Update an existing blog ")
	public ResponseEntity<BlogDTO> updateBlog(@Valid @RequestBody BlogDTO blogDto,
			@PathVariable @NotNull @Positive(message = "Blogs Id should be Positive Integer") Long id) {

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
	@Tag(name = "Delete an exisitng blog")
	public ResponseEntity<String> deleteBlog(
			@PathVariable @NotNull @Positive(message = "Blogs Id should be Positive Integer") Long id) {

		blogService.deleteBlog(id);
		return ResponseEntity.status(HttpStatus.OK).body("Successfully Deleted Blog and its Respected comment");
	}

	/**
	 * Retrieves a blog along with its comments.
	 *
	 * @param id The ID of the blog.
	 * @return ResponseEntity containing the {@link BlogWithCommentDTO}.
	 */
	@GetMapping("/blogs/{id}/comment")
	@Tag(name = "Fetch blog with comment using the blog id")
	public ResponseEntity<BlogWithCommentDTO> fetchBlogWithComment(
			@PathVariable @NotNull @Positive(message = "Blogs Id should be Positive Integer") Long id) {

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
	@Tag(name = "Add a comment to exisiting blog ")
	public ResponseEntity<CommentDTO> addComment(@Valid @RequestBody CommentDTO commentDto,
			@PathVariable @Positive(message = "Blogs Id should be Positive Integer") Long id) {
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
	@GetMapping("/blogs/{blogId}/comment/{commentId}")
	@Tag(name = "Fetch a specific comment using Id ")
	public ResponseEntity<CommentDTO> getComment(@PathVariable Long blogId,
			@PathVariable @Positive(message = "Blogs Id should be Positive Integer") Long commentId) {
		CommentDTO comment = commentService.fetchComment(blogId, commentId);
		return ResponseEntity.status(HttpStatus.OK).body(comment);
	}

	/**
	 * Remove a specific comment from a blog.
	 *
	 * @param commentId The ID of the comment.
	 * @return ResponseEntity containing the requested {@link CommentDTO}.
	 */
	@DeleteMapping("/blogs/{blogId}/comment/{commentId}")
	@Tag(name = "Delete a comment from blog using Id")
	public ResponseEntity<String> deleteComment(
			@PathVariable @Positive(message = "Comment Id should be Positive Integer") Long commentId, @PathVariable Long blogId) {

		Boolean comment = commentService.deleteComment(commentId,blogId);
		if (comment == true) {
			return ResponseEntity.status(HttpStatus.OK).body("Successfully Deleted !!! ");
		}

		return ResponseEntity.status(HttpStatus.OK).body("Failed to Deleted !!! ");

	}
}
