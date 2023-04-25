package com.lrm.springbootdemo.service;

import java.util.List;

import com.lrm.springbootdemo.domain.Book;

public interface BookService {

	/**
	 * create a new book
	 * 
	 * @param book
	 * @return
	 */
	Book createBook(Book book);

	/**
	 * get all books
	 * 
	 * @return
	 */
	List<Book> getAllBooks();

	/**
	 * get a book by id
	 * 
	 * @param id
	 * @return
	 */
	Book getBookById(long id);

	/**
	 * delete a book
	 * 
	 * @param id
	 */
	void deleteBook(long id);

	/**
	 * get books by author
	 * 
	 * @param author
	 * @return
	 */
	List<Book> findByAuthor(String author);

	/**
	 * get books by author and status
	 * 
	 * @param author
	 * @param status
	 * @return
	 */
	List<Book> findByAuthorAndStatus(String author, int status);

	List<Book> findByDescriptionContaining(String description);

}
