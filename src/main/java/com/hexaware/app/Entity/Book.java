package com.hexaware.app.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;

@Entity
public class Book {
	
	    @Id
	    @GeneratedValue
	    private Long id;

	 @NotBlank(message = "Title is mandatory")
	    @Size(min = 1, max = 255, message = "Title must be between 1 and 255 characters")
	    private String title;

	    @NotBlank(message = "Author is mandatory")
	    @Size(min = 1, max = 255, message = "Author must be between 1 and 255 characters")
	    private String author;

	    @NotBlank(message = "ISBN is mandatory")
	    @Pattern(regexp = "^[0-9]{13}$", message = "ISBN must be a valid 13-digit number")
	    private String isbn;

	    @NotNull(message = "Publication year is mandatory")
	    private Integer publicationYear;
    
    
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public int getPublicationYear() {
		return publicationYear;
	}
	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}

    // Getters and Setters
}
