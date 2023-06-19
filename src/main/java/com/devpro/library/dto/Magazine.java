package com.devpro.library.dto;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@ToString(callSuper=true)
public class Magazine extends Item {
	private String series;
	private String volume;

	public static Magazine createInstance(String title, String series, String volume, Integer copies){
		Magazine magazine = new Magazine();
		magazine.setId(UUID.randomUUID());
		magazine.setTitle(title);
		magazine.setSeries(series);
		magazine.setVolume(volume);
		magazine.setCopies(copies);
		magazine.setMaximumLoanDays(9);
		magazine.setLateFee(BigDecimal.valueOf(3.99));
		return  magazine;
	}

}
