package com.devpro.library.dto;

import com.devpro.library.service.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class Item {

	private UUID id;
	private String title;
	private Integer copies;
	private BigDecimal lateFee;
	private Integer maximumLoanDays;
	private Boolean isAlreadyBorrowed = false;
	private Boolean isReturned = false;

}
