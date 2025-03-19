package com.mapper;

import java.util.ArrayList;
import java.util.List;

import com.dto.BlogDTO;
import com.dto.BlogWithCommentDTO;
import com.dto.CommentDTO;
import com.entity.BlogEntity;

/**
 * Mapper class for converting between BlogEntity and DTOs. Provides utility
 * methods to transform data objects for API responses.
 */
public class BlogMapper {

	/**
	 * Converts a {@link BlogEntity} object to a {@link BlogDTO}.
	 *
	 * @param blogEntity The entity to be converted.
	 * @return A {@link BlogDTO} containing blog details.
	 */
	public static BlogDTO convertToDTO(BlogEntity blogEntity) {
		BlogDTO blog = new BlogDTO();
		blog.setTitle(blogEntity.getTitle());
		blog.setContent(blogEntity.getContent());
		blog.setId(blogEntity.getId());
		return blog;
	}

	/**
	 * Converts a {@link BlogDTO} object to a {@link BlogEntity}.
	 *
	 * @param blogDto The DTO to be converted.
	 * @return A {@link BlogEntity} containing blog details.
	 */
	public static BlogEntity convertToEntity(BlogDTO blogDto) {
		BlogEntity blog = new BlogEntity();
		blog.setId(blogDto.getId());
		blog.setTitle(blogDto.getTitle());
		blog.setContent(blogDto.getContent());
		return blog;
	}

	/**
	 * Converts a {@link BlogEntity} to a {@link BlogWithCommentDTO}, including its
	 * associated comments.
	 *
	 * @param blog The blog entity containing comments.
	 * @return A {@link BlogWithCommentDTO} with blog and comment details.
	 */
	public static BlogWithCommentDTO convertToCommentDTO(BlogEntity blog) {
		BlogWithCommentDTO blogDto = new BlogWithCommentDTO();
		List<CommentDTO> commentList = new ArrayList<>();

		blog.getComments().forEach(comment -> commentList.add(CommentMapper.convertToDTO(comment)));

		blogDto.setId(blog.getId());
		blogDto.setTitle(blog.getTitle());
		blogDto.setContent(blog.getContent());
		blogDto.setComments(commentList);

		return blogDto;
	}
}
