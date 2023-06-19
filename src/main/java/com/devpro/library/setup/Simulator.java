package com.devpro.library.setup;

import com.devpro.library.dto.Book;
import com.devpro.library.dto.Dvd;
import com.devpro.library.dto.User;
import com.devpro.library.service.ItemService;
import com.devpro.library.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class Simulator {

	private final ItemService itemService;
	private final UserService userService;

	public void start() throws Exception {
		InventoryManagementSystem inventory = new InventoryManagementSystem();
		User user = User.createUser("John");
		Book book = inventory.findBook("Dune");

		if (itemService.isBorrowedACopy(book, user)) {
			user.getBooks().add(book);
		}
		if (itemService.isReturnedACopy(user, book, 2)) {
			user.getBooks().remove(book);
		}
		Dvd dvd = inventory.findDvd("Lord of the Rings: Fellowship of the Rings");
		if (itemService.isBorrowedACopy(dvd, user)) {
			user.getDvds().add(dvd);
		}
		if (itemService.isReturnedACopy(user, dvd, 20)) {
			user.getDvds().remove(dvd);
		} else {
			if (user.getDues().compareTo(BigDecimal.ZERO) == 1) {
				BigDecimal cashGiven = BigDecimal.valueOf(0);
				userService.collectLateFees(user, cashGiven);
			}
		}

	}


}
