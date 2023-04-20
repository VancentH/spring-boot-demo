package com.lrm.springbootdemo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lrm.springbootdemo.domain.Book;
import com.lrm.springbootdemo.repository.BookRepository;
import com.lrm.springbootdemo.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	private BookRepository bookRepository;
	
	@Override
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

}
