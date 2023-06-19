package com.devpro.library.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Data
public class User {

	private UUID id;
	private String name;

	private BigDecimal dues;
	private List<Book> books;
	private List<Dvd> dvds;
	private List<Magazine> magazines;

	public static User createUser(String name){
		User user = new User();
		user.setId(UUID.randomUUID());
		user.setName(name);
		return user;
	}
}