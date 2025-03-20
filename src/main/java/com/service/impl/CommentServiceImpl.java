package com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.CommentDTO;
import com.entity.BlogEntity;
import com.entity.CommentEntity;
import com.exception.BlogNotFoundException;
import com.exception.CommentNotFoundException;
import com.mapper.CommentMapper;
import com.repository.BlogRepository;
import com.repository.CommentRepository;
import com.service.CommentService;

/**
 * Implementation of {@link CommentService} for managing comments on blogs.
 */
@Service
public class CommentServiceImpl implements CommentService {

	private final CommentRepository commentRepo;
	private final BlogRepository blogRepo;

	/**
	 * Constructor-based dependency injection.
	 *
	 * @param commentRepo Repository for comments.
	 * @param blogRepo    Repository for blogs.
	 */
	@Autowired
	public CommentServiceImpl(CommentRepository commentRepo, BlogRepository blogRepo) {
		this.commentRepo = commentRepo;
		this.blogRepo = blogRepo;
	}

	/**
	 * Creates a new comment for a given blog.
	 *
	 * @param blogId     The ID of the blog to associate the comment with.
	 * @param commentDto The comment details.
	 * @return The created {@link CommentDTO}.
	 * @throws BlogNotFoundException If the blog does not exist.
	 */
	@Override
	public CommentDTO createComment(Long blogId, CommentDTO commentDto) {
		BlogEntity blog = blogRepo.getBlogById(blogId)
				.orElseThrow(() -> new BlogNotFoundException("Cannot add comment: No blog exists with ID " + blogId));

		CommentEntity comment = CommentMapper.convertToEntity(commentDto);
		comment.setBlog(blog);

		commentRepo.save(comment);

		return CommentMapper.convertToDTO(comment);
	}

	/**
	 * Fetches a specific comment for a given blog.
	 *
	 * @param blogId    The ID of the blog.
	 * @param commentId The ID of the comment.
	 * @return The {@link CommentDTO} for the found comment.
	 * @throws BlogNotFoundException    If the blog does not exist.
	 * @throws CommentNotFoundException If the comment is not found for the given
	 *                                  blog.
	 */
	@Override
	public CommentDTO fetchComment(Long blogId, Long commentId) {
		BlogEntity blog = blogRepo.getBlogById(blogId)
				.orElseThrow(() -> new BlogNotFoundException("No blog exists with ID " + blogId));

		CommentEntity comment = commentRepo.fetchCommentById(commentId).orElseThrow(() -> new CommentNotFoundException(
				"No comment found with ID " + commentId + " for blog: " + blog.getTitle()));

		return CommentMapper.convertToDTO(comment);
	}

	@Override
	public Boolean deleteComment(Long commentId, Long blogId) {

		blogRepo.getBlogById(blogId).orElseThrow(() -> new BlogNotFoundException("No blog exists with ID " + blogId));

		CommentEntity comment = commentRepo.fetchCommentById(commentId)
				.orElseThrow(() -> new CommentNotFoundException("No comment found with ID " + commentId));
		commentRepo.delete(comment);

		if (commentRepo.existsById(commentId)) {
			return false;
		}

		return true;
	}
}
