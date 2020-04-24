package com.API.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.API.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
	
}