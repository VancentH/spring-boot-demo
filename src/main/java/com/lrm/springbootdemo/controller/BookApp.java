package com.lrm.springbootdemo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lrm.springbootdemo.domain.Book;
import com.lrm.springbootdemo.service.BookService;


// 外部控制器
@RestController
@RequestMapping("/v1")
public class BookApp {

	private BookService bookService;

	/**
	 * get book list
	 * @return
	 */
	// http://localhost:8082/api/v1/books
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getAll(){
		List<Book> books = bookService.getAllBooks();
		return  new ResponseEntity<>(books, HttpStatus.OK);
	}

}
