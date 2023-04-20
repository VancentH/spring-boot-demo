package com.lrm.springbootdemo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lrm.springbootdemo.domain.Book;
import com.lrm.springbootdemo.repository.BookRepository;
import com.lrm.springbootdemo.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Override
	public Book createBook(Book book) {
		return bookRepository.save(book);
	}

	@Override
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	@Override
	public Book getBookById(long id) {
		return bookRepository.findOne(id);
	}

	@Override
	public void deleteBook(long id) {
		// TODO Auto-generated method stub
	}

}
