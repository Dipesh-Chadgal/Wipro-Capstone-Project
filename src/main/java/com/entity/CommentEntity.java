package com.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
@Table(name = "Comment_Entity")
public class CommentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	
	@ManyToOne(cascade = CascadeType.ALL, targetEntity = BlogEntity.class)
	private Long blogId;
	
	private String comment;

}
