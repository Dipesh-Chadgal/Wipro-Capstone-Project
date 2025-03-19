package com.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * Entity class representing a blog post.
 * This entity is mapped to the "Blog" table in the database.
 */
@Entity
@Table(name = "Blog")
public class BlogEntity {

    /**
     * The unique identifier for the blog post.
     * It is auto-generated using an identity strategy.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
     * The list of comments associated with this blog post.
     * This establishes a one-to-many relationship between a blog and its comments.
     * Comments are cascaded, meaning they will be persisted or deleted along with the blog.
     */
    @OneToMany(mappedBy = "blog", cascade = CascadeType.ALL)
    private List<CommentEntity> comments = new ArrayList<>();
    
    
    /**
     * Getter and Setter methods for BlogEntity properties.
     */

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

	public List<CommentEntity> getComments() {
		return comments;
	}

	public void setComments(List<CommentEntity> comments) {
		this.comments = comments;
	}
	
	
	

}
