package com.devpro.library.dto;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@ToString(callSuper=true)
public class Book extends Item {


	private String author;
	private String genre;

 public static Book createInstance(String title, String author, String genre, Integer copies){
	 Book book = new Book();
	 book.setId(UUID.randomUUID());
	 book.setTitle(title);
	 book.setAuthor(author);
	 book.setGenre(genre);
	 book.setCopies(copies);
	 book.setMaximumLoanDays(14);
	 book.setLateFee(BigDecimal.valueOf(2.99));
	 return book;
 }


}
