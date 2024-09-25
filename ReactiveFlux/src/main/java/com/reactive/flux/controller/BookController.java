package com.reactive.flux.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.reactive.flux.entites.Book;
import com.reactive.flux.service.BookService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/books")
public class BookController {



	@Autowired
	private BookService bookService;

	@PostMapping
	public Mono<ResponseEntity<Book>> create(@RequestBody Book book) {

		return bookService.create(book)
				.map(ResponseEntity::ok);
	}




	@GetMapping("/{bid}")
	public Mono<ResponseEntity<Book>> get(@PathVariable("bid") int bookId) {

		return bookService.get(bookId)
				.map(ResponseEntity::ok);
	}


	@GetMapping
	public Flux<Book> getAllBooks() {
	    return bookService.getAll();
	}

	
	//    update
	@PutMapping("/{bookId}")
	public Mono<ResponseEntity<Book>> update(@RequestBody Book book, @PathVariable int bookId) {

		return bookService.update(book, bookId)
				.map(ResponseEntity::ok);
	}

	//    delete
	@DeleteMapping("/{bookId}")
	public Mono<ResponseEntity<Void>> delete(@PathVariable int bookId) {

		return bookService.delete(bookId)
				.map(ResponseEntity::ok);
	}

	//	    search

	@GetMapping("/search")
	public Flux<ResponseEntity<Book>> searchBooks(
			@RequestParam("query") String query
			) {
		System.out.println(query);
		return this.bookService.searchBooks(query)
				.map(ResponseEntity::ok);
	}








}
