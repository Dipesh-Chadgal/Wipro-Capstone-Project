package com.controller;

import java.util.List;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.BlogDto;

@RestController
@RequestMapping("/api")
@EnableAutoConfiguration
public class BlogController {

	/*
	 * =============================================================================
	 * GET AND POST MAPPING TO FETCH ALL BLOGS AND TO ADD A NEW BLOG
	 * 
	 * 
	 * GET
	 * 
	 * If Blog are present then Response code: 200 (OK) If No Blog are present then
	 * Response code: 204 ( No Content)
	 * 
	 * 
	 * POST
	 * 
	 * Successful Blog creation Response code: 201 (Created) If title or content is
	 * blank then Response code: 400 (Bad request)
	 * 
	 */

	@GetMapping("/blogs")
	public ResponseEntity<List<BlogDto>> getAllBlogs() {
		// have to write the code
		return null;
	}

	@PostMapping("/blogs")
	public ResponseEntity<BlogDto> addBlog() {
		// have to write the code
		return null;
	}

	/*
	 * =============================================================================
	 * GET MAPPING FOR FETCHING AN EXISTING BLOG
	 * 
	 * If blog id is valid then Response code: 200 (OK) 
	 * If blog id is invalid then Response code: 404 (Not Found)
	 * 
	 */

	@GetMapping("/blogs/{id}")
	public ResponseEntity<BlogDto> getBlogById() {

		return null;
	}

	/*
	 * =============================================================================
	 * PUT MAPPING FOR UPDATING AN EXISTING BLOG
	 * 
	 * If blog id is valid and update is successful then Response code: 200 (OK) If
	 * blog id is invalid then Response code: 404 (Not Found) 
	 * If request body is invalid then Response code: 400 (Bad Request)
	 */

	@PutMapping("/blogs/{id}")
	public ResponseEntity<BlogDto> updateBlog() {
		// have to write the code
		return null;
	}

	/*
	 * =============================================================================
	 * DELETE MAPPING FOR DELETING AN EXISTING BLOG
	 * 
	 * If blog id is valid and deletion is successful then Response code: 200 (OK)
	 * If blog id is invalid then Response code: 404 (Not Found)
	 */

	@DeleteMapping("/blogs/{id}")
	public ResponseEntity<BlogDto> deleteBlog() {
		// have to write the code
		return null;
	}

	/*
	 * =============================================================================
	 * GET MAPPING FOR FETCHING ALL THE COMMENT FROM A PARTICULAR BLOG 
	 * 
	 * If blog id is valid and comments are present then Response code: 200 (OK) 
	 * If blog id is valid but no comments are present then Response code: 204 (No Content)
	 * If blog id is invalid then Response code: 404 (Not Found)
	 * 
	 */

	@GetMapping("/blogs/{id}/comment")
	public ResponseEntity<BlogDto> fetchAllComment() {
		// have to write the code
		return null;
	}

	/*
	 * =============================================================================
	 * POST MAPPING TO ADDING A NEW COMMENT ON THE EXISITING BLOG
	 * 
	 * 
	 * If blog id is valid and comment is added successfully then Response code: 201 (Created) 
	 * If blog id is invalid then Response code: 404 (Not Found) 
	 * If request body is invalid then Response code: 400 (Bad Request)
	 * 
	 */

	@PostMapping("/blogs/{id}/comment")
	public ResponseEntity<BlogDto> addComment() {
		// have to write the code
		return null;
	}

}
