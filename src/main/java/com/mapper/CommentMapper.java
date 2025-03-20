package com.mapper;

import com.dto.CommentDTO;
import com.entity.CommentEntity;

/**
 * Mapper class for converting between CommentEntity and CommentDTO.
 * Provides utility methods to transform comment data objects.
 */
public class CommentMapper {

    /**
     * Converts a {@link CommentEntity} object to a {@link CommentDTO}.
     *
     * @param commentEntity The entity to be converted.
     * @return A {@link CommentDTO} containing comment details.
     */
    public static CommentDTO convertToDTO(CommentEntity commentEntity) {
        CommentDTO commentDto = new CommentDTO();
        commentDto.setBlogId(commentEntity.getBlog().getId());
        commentDto.setId(commentEntity.getId());
        commentDto.setComment(commentEntity.getComment());
        commentDto.setCreatedAt(commentEntity.getCreatedAt());
        return commentDto;
    }

    /**
     * Converts a {@link CommentDTO} object to a {@link CommentEntity}.
     * 
     * <p>Note: The blog association is not set in this method.
     * It should be handled separately before persisting the entity.</p>
     *
     * @param commentDto The DTO to be converted.
     * @return A {@link CommentEntity} containing comment details.
     */
    public static CommentEntity convertToEntity(CommentDTO commentDto) {
        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setComment(commentDto.getComment());
        return commentEntity;
    }
}
