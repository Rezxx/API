package com.API.controller;

import com.API.model.Book;
import com.API.repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value="/books/**")
public class BookController {
	@Autowired
    BookRepository bookRepository;
	
	// Get All Books
    @GetMapping("/")
    public List<Book> getAllNotes() {
        return bookRepository.findAll();
    }
    
    // Create a new Note
    @PostMapping("/add")
    public Book createNote(@Valid @RequestBody Book book) {
        return bookRepository.save(book);
    }
    
    // Get a Single Book
    @GetMapping("/{id}")
    public Book getNoteById(@PathVariable(value = "id") Long bookId) {
        return bookRepository.findById(bookId).get();
    }
    
    // Update a Book
    @PutMapping("/{id}")
    public Book updateNote(@PathVariable(value = "id") Long bookId,
                           @Valid @RequestBody Book bookDetails) {
    	Book book = bookRepository.findById(bookId).get();
    	book.setTitle(bookDetails.getTitle());
    	book.setAuthor(bookDetails.getAuthor());
    	
    	return bookRepository.save(book);
    }
    
    // Delete a Book
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable(value = "id") Long bookId) {
        Book book = bookRepository.findById(bookId).get();

		bookRepository.delete(book);
		return ResponseEntity.ok().build();
    }
    
}
