package com.devpro.library.service;

import com.devpro.library.dto.Item;
import com.devpro.library.dto.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class ItemService {

	private final UserService userService;


	public boolean checkItemAvailable(Item item) {
		return item.getCopies() > 0 ? true : false;
	}

	public boolean isBorrowedACopy(Item item, User user) throws IllegalAccessException {
		if (user.getDues().compareTo(BigDecimal.ZERO) == 1) {
			throw new IllegalAccessException("Outstanding dues of +" + user.getDues() + "+ are there unable to borrow books now! ");
		}


		boolean status = false;
		if (checkItemAvailable(item)) {
			item.setCopies(item.getCopies() - 1);
			status = true;
		}
		System.out.println("Borrowing a copy of " + item.getTitle() + "status is " + status);
		return status;
	}

	public boolean isReturnedACopy(User user, Item item, int days) {
		boolean status = false;
		if (isLateFeesApplicable(item, days)) {
			userService.applyLateFees(user, item);
		} else {
			status = true;
			item.setCopies(item.getCopies() + 1);
		}
		System.out.println("User has an outstanding dues: $ " + user.getDues());
		return status;
	}

	private boolean isLateFeesApplicable(Item item, int days) {
		boolean status = false;
		if (days > item.getMaximumLoanDays()) {
			status = true;
		}
		return status;
	}
}
