package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Entity class representing a comment on a blog post.
 * This entity is mapped to the "Comment" table in the database.
 */
@Entity
@Table(name = "Comment")
public class CommentEntity {

    /**
     * The unique identifier for the comment.
     * It is auto-generated using an identity strategy.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * The blog post to which this comment belongs.
     * This establishes a many-to-one relationship with the BlogEntity.
     */
    @ManyToOne
    @JoinColumn(name = "blog_id") // Foreign key column in the Comment table
    private BlogEntity blog;

    /**
     * The content of the comment.
     */
    private String comment;
	
	
	/**
	 * Getter and Setter methods for CommentDTO properties.
	 */
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		id = id;
	}
	public BlogEntity getBlog() {
		return blog;
	}
	public void setBlog(BlogEntity blog) {
		this.blog = blog;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	

}
