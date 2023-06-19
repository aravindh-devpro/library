package com.devpro.library.dto;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@ToString(callSuper=true)
public class Dvd extends  Item{

	private String director;
	private String genre;

	public static Dvd createInstance(String title, String director, String genre, Integer copies){
		Dvd dvd = new Dvd();
		dvd.setId(UUID.randomUUID());
		dvd.setTitle(title);
		dvd.setDirector(director);
		dvd.setCopies(copies);
		dvd.setGenre(genre);
		dvd.setMaximumLoanDays(9);
		dvd.setLateFee(BigDecimal.valueOf(4.5));
		return dvd;
	}
}
