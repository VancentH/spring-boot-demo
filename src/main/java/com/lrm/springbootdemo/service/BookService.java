package com.lrm.springbootdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lrm.springbootdemo.domain.Book;
import com.lrm.springbootdemo.domain.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	/**
	 * get all the books
	 * 
	 * @return
	 */
	public List<Book> findAll() {
		return bookRepository.findAll();
	}

}
