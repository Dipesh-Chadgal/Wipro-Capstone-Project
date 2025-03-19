package com.dto;

import org.hibernate.validator.constraints.Length;
import jakarta.validation.constraints.NotBlank;

/**
 * Data Transfer Object (DTO) for Blog.
 * <p>
 * This class is used to transfer blog data between layers while ensuring 
 * validation constraints.
 * </p>
 * 
 * @author Dipesh Singh Chadgal 
 */
public class BlogDTO {

    /** The unique identifier for the blog. */
    private Long id;

    /** 
     * The title of the blog.
     * <p>
     * Constraints:
     * - Cannot be blank.
     * - Must be between 3 and 100 characters.
     * </p>
     */
    @NotBlank
    @Length(min = 3, max = 100, message = "Title Length Must be between 3 to 100 Characters")
    private String title;

    /** 
     * The content of the blog.
     * <p>
     * Constraints:
     * - Cannot be blank.
     * - Must be between 3 and 100 characters.
     * </p>
     */
    @NotBlank
    @Length(min = 3, max = 200, message = "Content Length Must be between 3 to 200 Characters")
    private String content;

    
    /**
     * Getter and Setter methods for BlogDTO properties.
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
    
}
