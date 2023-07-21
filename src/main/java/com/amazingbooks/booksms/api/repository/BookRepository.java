package com.amazingbooks.booksms.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amazingbooks.booksms.api.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
	List<Book> findByTitle(String title);
}