package com.lrm.springbootdemo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lrm.springbootdemo.domain.Book;
import com.lrm.springbootdemo.service.BookService;
import com.lrm.springbootdemo.service.impl.BookServiceImpl;

// 外部控制器
@RestController
@RequestMapping("/v1")
public class BookApp {

	@Autowired
	private BookServiceImpl bookServiceImpl;

	/**
	 * 取得所有書清單
	 * 
	 * @return
	 */
	// http://localhost:8082/api/v1/books
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getAll() {
		List<Book> books = bookServiceImpl.getAllBooks();
		return new ResponseEntity<>(books, HttpStatus.OK);
	}

	/**
	 * 取得一本書
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/books/{id}")
	public Book getOne(@PathVariable long id) {
		return bookServiceImpl.getBookById(id);
	}

	/**
	 * 新增一本書
	 * 
	 * @param book
	 * @return
	 */
	@PostMapping("/books")
	public Book post(Book book) {
		return bookServiceImpl.createBook(book);
	}

	/**
	 * 更新一本書
	 * 
	 * @param id
	 * @param name
	 * @param author
	 * @param description
	 * @param status
	 * @return
	 */
	@PutMapping("/books")
	public Book update(@RequestParam long id, @RequestParam String name, @RequestParam String author,
			@RequestParam String description, @RequestParam int status) {
		Book book = new Book();
		book.setId(id);
		book.setName(name);
		book.setAuthor(author);
		book.setDescription(description);
		book.setStatus(status);
		// update and create both using repository.save()
		return bookServiceImpl.createBook(book);
	}

	/**
	 * 刪除一本書
	 * 
	 * @param id
	 */
	@DeleteMapping("/books/{id}")
	public void delete(@PathVariable long id) {
		bookServiceImpl.deleteBook(id);
	}

	@PostMapping("/books/by/author")
	public List<Book> findByAuthor(@RequestParam String author) {
		return bookServiceImpl.findByAuthor(author);
	}

	@PostMapping("/books/by/authorAndStatus")
	public List<Book> findByAuthorAndStatus(@RequestParam String author, @RequestParam int status) {
		return bookServiceImpl.findByAuthorAndStatus(author, status);
	}

	@PostMapping("/books/by/description")
	public List<Book> findByDescription(@RequestParam String description) {
		return bookServiceImpl.findByDescriptionContaining(description);
	}

	/**
	 * 使用書名的長度來尋找書本資料
	 * 
	 * @param length
	 * @return
	 */
	@PostMapping("/books/by/length")
	public List<Book> findByLengthOfName(@RequestParam int length) {
		return bookServiceImpl.findByJPQL(length);
	}

	@PutMapping("/books/name")
	public int updateName(@RequestParam String name, @RequestParam long id) {
		return bookServiceImpl.updateByJPQL(name, id);
	}
	
	@PutMapping("/books/status")
	public int updateName(@RequestParam int status, @RequestParam long id) {
		return bookServiceImpl.updateStatusByJPQL(status, id);
	}
	
	@DeleteMapping("/books/by/id")
	public int deleteById(@RequestParam long id) {
		return bookServiceImpl.deleteByJPQL(id);
	}
	
	
	/**
	 * 測試交易的原子性
	 */
	@PostMapping("/books/transaction")
	public int deleteAndUpdate(@RequestParam long id, @RequestParam int status, @RequestParam long uid) {
		return bookServiceImpl.deleteAndUpdate(id, status, uid);
	}
}
