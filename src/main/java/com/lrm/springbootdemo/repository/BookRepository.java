package com.lrm.springbootdemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.lrm.springbootdemo.domain.Book;

import jakarta.transaction.Transactional;

// 資料操作層
public interface BookRepository extends CrudRepository<Book, Long> {

	Book findById(long id);

	List<Book> findByAuthor(String author);

	List<Book> findByAuthorAndStatus(String autho, int status);

	List<Book> findByDescriptionContaining(String description);

//	@Query("SELECT b FROM Book b WHERE length(b.name) > ?1")
	@Query(value = "SELECT * FROM book b WHERE LENGTH(b.name) > ?1", nativeQuery = true)
	List<Book> findByJPQL(int length);

	@Modifying
	@Transactional
	@Query("UPDATE Book b SET b.name = ?1 WHERE b.id = ?2")
	int updateByJPQL(String name, long id);
	
	@Modifying
	@Transactional
	@Query("UPDATE Book b SET b.status = ?1 WHERE b.id = ?2")
	int updateStatusByJPQL(int status, long id);

	@Modifying
	@Transactional
	@Query("DELETE FROM Book b WHERE b.id = ?1")
	int deleteByJPQL(long id);

}
