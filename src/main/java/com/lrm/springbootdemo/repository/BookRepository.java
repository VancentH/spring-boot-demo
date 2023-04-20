package com.lrm.springbootdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lrm.springbootdemo.domain.Book;

// 資料操作層
public interface BookRepository extends JpaRepository<Book, Long> {

	Book findOne(long id);

//	Book createBook(Book book);
//
//	List<Book> findAll();
//
//	Book getBookById(Long id);
//
//	void deleteBook(Long id);

}
