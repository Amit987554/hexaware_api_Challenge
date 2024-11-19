package com.hexaware;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import com.hexaware.app.Service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.app.Dao.BookRepository;
import com.hexaware.app.Entity.Book;

@SpringBootTest
class BookAPIApplicationTests {
    @Autowired BookRepository bookRep;
    @Autowired
    BookService bookService;

    @Test
    void addNewbook() {
        Book b= new Book();
        b.setTitle("SUPER HUMANS");
        b.setIsbn("9876543210987");
        b.setAuthor("Hemilton");
        b.setPublicationYear(2009);
        bookRep.save(b);
    }

    @Test
    void deleteExistingBook() {
        bookService.deleteBook("9876543210987");
    }


    @Test
    void getAllBooksInTheTable() {
        List<Book> actualBookList = (List<Book>) bookRep.findAll();
        int listSize = actualBookList.size();

        assertEquals(2, listSize);
    }

    @Test
    void getBookByIsbnInTheTable() {
        Book actualBook = bookRep.findByIsbn((String) "9876543210987");


        Book expBook = new Book();
        expBook.setTitle("Ponniyin Selvan 1");

        assertEquals(actualBook.getTitle(), expBook.getTitle(), "");
    }

    @Test
    void updateBookInTheTable() {
        Book actualBook = bookRep.findByIsbn((String)"9876543210987");

        actualBook.setTitle("java");

        bookRep.save(actualBook);

        assertEquals(actualBook.getTitle(), "java", "");
    }

}
