package com.lrm.springbootdemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lrm.springbootdemo.domain.Book;

// 資料操作層
public interface BookRepository extends JpaRepository<Book, Long> {

	// Book findById(long id);

	List<Book> findAll();
}
