package com.lrm.springbootdemo.repository;

import org.springframework.data.repository.CrudRepository;

import com.lrm.springbootdemo.domain.Book;

// 資料操作層
public interface BookRepository extends CrudRepository<Book, Long> {

	Book findById(long id);
}
