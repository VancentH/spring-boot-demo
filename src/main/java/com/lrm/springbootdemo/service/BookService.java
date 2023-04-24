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
	 * @param id
	 */
	void deleteBook(long id);

}
