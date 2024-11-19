package com.hexaware.app.Exception;



public class BookNotFoundException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BookNotFoundException(String isbn) {
        super("Book not found with ISBN: " + isbn);
    }
}