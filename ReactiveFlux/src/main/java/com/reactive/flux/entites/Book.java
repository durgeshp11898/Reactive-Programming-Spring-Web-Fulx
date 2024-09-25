package com.reactive.flux.entites;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table("book_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {

	@Id
	@Column("book_id")
	private  int bookId;

	private  String name;

	@Column("book_desc")
	private  String description;

	private  String publisher;

	private  String author;




}
