package com.devpro.library.setup;

import com.devpro.library.dto.Book;
import com.devpro.library.dto.Dvd;
import com.devpro.library.dto.Magazine;
import com.devpro.library.dto.User;

import java.util.ArrayList;
import java.util.List;

public class InventoryManagementSystem {
	private List<Book> books = new ArrayList<>();
	private List<Dvd> dvds = new ArrayList<>();
	private List<Magazine> magazines = new ArrayList<>();

	public InventoryManagementSystem() {
		initBooks();
		intDvds();
		initMagazines();
		printInventory();
		User john = User.createUser("John");
		String bookName = "Dune";

	}

	private void printInventory() {
		books.forEach(System.out::println);
		dvds.forEach(System.out::println);
		magazines.forEach(System.out::println);
	}

	private void initBooks() {
		Book dune = Book.createInstance("Dune", "David", "Motivational", 5);
		Book hamlet = Book.createInstance("Hamlet", "Sxhwartz", "Travel", 4);
		Book diviners = Book.createInstance("The diviners", "Multi Author", "Biography", 1);
		books.add(dune);
		books.add(hamlet);
		books.add(diviners);
	}

	private void intDvds() {
		Dvd rings = Dvd.createInstance("Lord of the Rings: Fellowship of the Rings", "James Bond", "Mythology", 2);
		Dvd devil = Dvd.createInstance("The Devil Wears Prada", "Derek", "Horror", 1);
		dvds.add(rings);
		dvds.add(devil);
	}

	private void initMagazines() {
		Magazine dragons = Magazine.createInstance("All About Chrome Dragons", "2.5.1", "II", 1);
		Magazine cakes = Magazine.createInstance("The Most Refreshing Summer Cakes", "8.5.1", "X", 2);
		magazines.add(dragons);
		magazines.add(cakes);
	}


	public Book findBook(String name) {
		return books.stream().filter(book -> book.getTitle()
						.equalsIgnoreCase(name)).findFirst().
				orElseThrow(() -> new IllegalArgumentException("No book available for the given " + name));
	}


	public Magazine findMagazine(String name) {
		return magazines.stream().filter(magazine -> magazine.getTitle()
						.equalsIgnoreCase(name)).findFirst().
				orElseThrow(() -> new IllegalArgumentException("No magazine available for the given " + name));
	}

	public Dvd findDvd(String name) {
		return dvds.stream().filter(dvd -> dvd.getTitle()
						.equalsIgnoreCase(name)).findFirst().
				orElseThrow(() -> new IllegalArgumentException("No Dvd available for the given " + name));
	}

	public List<Book> getBooks() {
		return books;
	}

	public List<Magazine> getMagazines() {
		return magazines;
	}

	public List<Dvd> getDvds() {
		return dvds;
	}


}
