package com.amazingbooks.booksms.api.controller;

import java.util.List;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.amazingbooks.booksms.api.exceptions.BookIdMismatchException;
import com.amazingbooks.booksms.api.exceptions.BookNotFoundException;
import com.amazingbooks.booksms.api.model.Book;
import com.amazingbooks.booksms.api.repository.BookRepository;

@RestController
@RequestMapping("/books")
public class BookRestController {

	//private static final Logger logger = LoggerFactory.getLogger(BookRestController.class);
	
	@Autowired
    private BookRepository bookRepository;

    @GetMapping
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @GetMapping("/search")
    public List<Book> findByTitle(@RequestParam(required = true) String title) {
        return bookRepository.findByTitle(title);
    }

    @GetMapping("/{isbn}")
    public Book findById(@PathVariable Long isbn) {
        return bookRepository.findById(isbn)
          .orElseThrow(BookNotFoundException::new);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book save(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @DeleteMapping("/{isbn}")
    public void delete(@PathVariable Long isbn) {
        bookRepository.findById(isbn)
          .orElseThrow(BookNotFoundException::new);
        bookRepository.deleteById(isbn);
    }

    @PutMapping("/{isbn}")
    public Book update(@RequestBody Book book, @PathVariable Long isbn) {
        if (book.getIsbn() != isbn) {
          throw new BookIdMismatchException();
        }
        bookRepository.findById(isbn)
          .orElseThrow(BookNotFoundException::new);
        return bookRepository.save(book);
    }
}
