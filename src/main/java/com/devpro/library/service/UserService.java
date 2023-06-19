package com.devpro.library.service;

import com.devpro.library.dto.Item;
import com.devpro.library.dto.User;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class UserService {

	public void applyLateFees(User user, Item item) {
		user.setDues(user.getDues().add(item.getLateFee()));
	}

	public BigDecimal collectLateFees(User user, BigDecimal cashGiven) throws Exception {
		BigDecimal balance = BigDecimal.ZERO;
		if (cashGiven.compareTo(user.getDues()) >= 0) {
			balance = cashGiven.subtract(user.getDues());
		} else {
			throw new Exception("Given amount is not sufficient for the dues of " + user.getDues());
		}
		return balance;
	}
}
