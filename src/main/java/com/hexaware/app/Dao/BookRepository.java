package com.hexaware.app.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hexaware.app.Entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
    Book findByIsbn(String isbn);
}
