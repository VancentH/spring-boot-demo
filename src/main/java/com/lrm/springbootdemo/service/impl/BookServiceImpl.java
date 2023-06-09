package com.lrm.springbootdemo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lrm.springbootdemo.domain.Book;
import com.lrm.springbootdemo.repository.BookRepository;
import com.lrm.springbootdemo.service.BookService;

import jakarta.transaction.Transactional;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Override
	public Book createBook(Book book) {
		// 原先寫法
		// book.setId(0);
		// book.setName("xxx");
		// book.setAuthor("xxx");
		// book.setStatus(0);
		// book.setDescription("xxx");
		return bookRepository.save(book);
	}

	// use lambda expression in order to return a list
	// 將所有books加入至books這個list中
	@Override
	public List<Book> getAllBooks() {
		List<Book> books = new ArrayList<>();
		bookRepository.findAll().forEach(books::add);
		return books;
	}

	@Override
	public Book getBookById(long id) {
		return bookRepository.findById(id);
	}

	@Override
	public void deleteBook(long id) {
		bookRepository.deleteById(id);
	}

	@Override
	public List<Book> findByAuthor(String author) {
		return bookRepository.findByAuthor(author);
	}

	@Override
	public List<Book> findByAuthorAndStatus(String author, int status) {
		return bookRepository.findByAuthorAndStatus(author, status);
	}

	@Override
	public List<Book> findByDescriptionContaining(String description) {
		return bookRepository.findByDescriptionContaining(description);
	}

	@Override
	public List<Book> findByJPQL(int length) {
		return bookRepository.findByJPQL(length);
	}

	@Override
	public int updateByJPQL(String name, long id) {
		return bookRepository.updateByJPQL(name, id);
	}

	@Override
	public int deleteByJPQL(long id) {
		return bookRepository.deleteByJPQL(id);
	}

	@Override
	public int updateStatusByJPQL(int status, long id) {
		return bookRepository.updateStatusByJPQL(status, id);
	}

	@Transactional
	@Override
	public int deleteAndUpdate(long id, int status, long uid) {
		int dcount = bookRepository.deleteByJPQL(id);
		int ucount = bookRepository.updateStatusByJPQL(status, uid);
		return dcount + ucount;
	}

}
