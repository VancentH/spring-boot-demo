package com.lrm.springbootdemo.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// 資料操作層
public interface BookRepository extends JpaRepository<Book, Long>{

}
