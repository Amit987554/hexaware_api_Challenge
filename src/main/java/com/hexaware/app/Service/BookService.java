package com.hexaware.app.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hexaware.app.Entity.Book;
import com.hexaware.app.Dao.BookRepository;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn);
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBook(String isbn, Book updatedBook) {
        Book book = bookRepository.findByIsbn(isbn);
        if (book != null) {
            book.setTitle(updatedBook.getTitle());
            book.setAuthor(updatedBook.getAuthor());
            book.setPublicationYear(updatedBook.getPublicationYear());
            return bookRepository.save(book);
        }
        return null;
    }

    public void deleteBook(String isbn) {
        Book book = bookRepository.findByIsbn(isbn);
        if (book != null) {
            bookRepository.delete(book);
        }
    }
}
