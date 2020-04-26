package com.API.controller;

import com.API.model.Book;
import com.API.repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import javax.validation.Valid;
import java.util.List;

@RestController
public class BookController {
	@Autowired
    BookRepository bookRepository;
	
	// Get a Single Book
    @GetMapping("/book/{id}")
    public Book getBookById(@PathVariable(value = "id") Long bookId) {
        return bookRepository.findById(bookId).get();
    }
    
	// Get All Books
    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
    
    // Create a new Note
    @PostMapping("/add")
    public Book createBook(@Valid @RequestBody Book book) {
        return bookRepository.save(book);
    }
  
    
    // Update a Book
    @PutMapping("/book/{id}")
    public Book updateBook(@PathVariable(value = "id") Long bookId,
                           @Valid @RequestBody Book bookDetails) {
    	Book book = bookRepository.findById(bookId).get();
    	book.setTitle(bookDetails.getTitle());
    	book.setAuthor(bookDetails.getAuthor());
    	
    	return bookRepository.save(book);
    }
    
    // Delete a Book
    @DeleteMapping("/book/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable(value = "id") Long bookId) {
        Book book = bookRepository.findById(bookId).get();

		bookRepository.delete(book);
		return ResponseEntity.ok().build();
    }
    
}
