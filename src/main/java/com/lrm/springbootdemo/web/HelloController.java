package com.lrm.springbootdemo.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController
@RequestMapping("/v2")
public class HelloController {

	@GetMapping("/say")
	public String hello() {
		return "Hello Spring Boot";
	}
	
	@GetMapping("/books")
	public Object getAll(@RequestParam("page") int page, @RequestParam(value = "size", defaultValue = "10") int size) {
		
		Map<String, Object> book1 = new HashMap<>();
		book1.put("name", "書1");
		book1.put("author", "作者1");
		book1.put("isbn", "ISBN1");
		Map<String, Object> book2 = new HashMap<>();
		book2.put("name", "書2");
		book2.put("author", "作者2");
		book2.put("isbn", "ISBN2");
		
		List<Map> list = new ArrayList<>();
		list.add(book1);
		list.add(book2);
		
		Map<String, Object> pageMap =new HashMap<>();
		pageMap.put("page", page);
		pageMap.put("size", size);
		pageMap.put("books", list);
		return pageMap;
	}

	/**
	 * regular expression: {id: regular expression}
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/books/{id:[1-9_]+}")
	public Object getOne(@PathVariable long id) {

		System.out.println("id: " + id);

		Map<String, Object> map = new HashMap<>();
		map.put("name", "hello");
		map.put("age", 18);
		return map;
	}

	@PostMapping("/books")
	public Object post(@RequestParam("name") String name, @RequestParam("author") String author,
			@RequestParam("isbn") String isbn) {
		Map<String, Object> map = new HashMap<>();
		map.put("name", name);
		map.put("author", author);
		map.put("isbn", isbn);
		return map;
	}
}
