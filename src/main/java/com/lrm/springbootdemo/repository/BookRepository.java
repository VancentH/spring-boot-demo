package com.lrm.springbootdemo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.lrm.springbootdemo.domain.Book;

// 資料操作層
public interface BookRepository extends CrudRepository<Book, Long> {

	Book findById(long id);
	
	List<Book> findByAuthor(String author);
	
	List<Book> findByAuthorAndStatus(String autho, int status);
	
	List<Book> findByDescriptionContaining(String description);
}
