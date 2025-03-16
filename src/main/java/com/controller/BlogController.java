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
	 * PUT MAPPING FOR UPDATING AN EXISTING BLOG
	 */

	@PutMapping("/blogs/{id}")
	public ResponseEntity<BlogDto> updateBlog() {
		// have to write the code
		return null;
	}

	/*
	 * =============================================================================
	 * DELETE MAPPING FOR DELETING AN EXISTING BLOG
	 */
	@DeleteMapping("/blogs/{id}")
	public ResponseEntity<BlogDto> deleteBlog() {
		// have to write the code
		return null;
	}

	/*
	 * =============================================================================
	 * GET MAPPING FOR FETCHING ALL THE COMMENT FROM A PARTICULAR BLOG
	 */

	@GetMapping("/blogs/{id}/comment")
	public ResponseEntity<BlogDto> fetchAllComment() {
		// have to write the code
		return null;
	}

	/*
	 * =============================================================================
	 * POST MAPPING TO ADDING A NEW COMMENT ON THE EXISITING BLOG
	 */

	@PostMapping("/blogs/{id}/comment")
	public ResponseEntity<BlogDto> addComment() {
		// have to write the code
		return null;
	}

}
