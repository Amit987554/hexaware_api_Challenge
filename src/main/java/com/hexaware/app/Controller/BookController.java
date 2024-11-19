package com.hexaware.app.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.hexaware.app.Entity.Book;
import com.hexaware.app.Service.BookService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private BookService bookService;

    // Get all books
    @GetMapping("/all")
    public ResponseEntity<List<Book>> getAllBooks() {
        return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
    }

    // Get a book by ISBN
    @GetMapping("/{isbn}")
    public ResponseEntity<Book> getBookByIsbn(@PathVariable String isbn) {
        return new ResponseEntity<>(bookService.getBookByIsbn(isbn), HttpStatus.OK);
    }

    // Add a new book (Admin)
    @PostMapping("/add")
    public ResponseEntity<Book> addBook(@Valid @RequestBody Book book) {
        Book newBook = bookService.addBook(book);
        return new ResponseEntity<>(newBook, HttpStatus.CREATED);
    }

    // Update an existing book (Admin)
    @PutMapping("/update/{isbn}")
    public ResponseEntity<Book> updateBook(@PathVariable String isbn, @Valid @RequestBody Book updatedBook) {
        Book book = bookService.updateBook(isbn, updatedBook);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    // Delete a book by ISBN (Admin)
    @DeleteMapping("/delete/{isbn}")
    public ResponseEntity<Void> deleteBook(@PathVariable String isbn) {
        bookService.deleteBook(isbn);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
