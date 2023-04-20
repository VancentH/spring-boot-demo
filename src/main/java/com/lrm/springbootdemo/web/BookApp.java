package com.lrm.springbootdemo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lrm.springbootdemo.domain.Book;
import com.lrm.springbootdemo.service.BookService;


// 外部控制器
@RestController
@RequestMapping("/v1")
public class BookApp {

	@Autowired
	private BookService bookService;

	/**
	 * get book list
	 * @return
	 */
	@GetMapping("/books")
	public List<Book> getAll(){
		return bookService.findAll();
	}

}
