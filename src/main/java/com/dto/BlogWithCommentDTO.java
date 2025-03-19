package com.dto;

import java.util.List;

/**
 * Data Transfer Object (DTO) for representing a blog post along with its
 * associated comments. This class is used to return a blog post's details along
 * with a list of comments.
 */
public class BlogWithCommentDTO {

	/**
	 * The unique identifier of the blog.
	 */
	private Long id;

	/**
	 * The title of the blog post.
	 */
	private String title;

	/**
	 * The content of the blog post.
	 */
	private String content;

	/**
	 * A list of comments associated with this blog post. This helps retrieve all comments linked to a specific blog.
	 */
	private List<CommentDTO> comments;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<CommentDTO> getComments() {
		return comments;
	}

	public void setComments(List<CommentDTO> comments) {
		this.comments = comments;
	}

}
