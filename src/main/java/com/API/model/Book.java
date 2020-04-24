package com.API.model;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "Book")
public class Book {
	@Id
	@GeneratedValue
    private Long id;

	@NotBlank
    private String title;

	@NotBlank
    private String author;
	
	public Book() {
		
	}
	
	public Book(Long id, String title, String author) {
        super();
        this.id = id;
        this.title = title;
        this.author = author;
    }
	
	
	// Getters and Setters
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
	
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
}
