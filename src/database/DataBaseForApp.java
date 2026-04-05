package database;

import java.util.ArrayList;

import entity.Book;
import entity.User;

public class DataBaseForApp {
	public static ArrayList<Book> books = new ArrayList<>();
	static {
		books.add(new Book("c++", "raju", 101, 4.5));
		books.add(new Book("java", "babu", 501, 4.4));
		books.add(new Book("os", "sham", 108, 4.6));
		books.add(new Book("design pattern", "sam", 404, 4.5));
	}
	public static ArrayList<User> users = new ArrayList<>();
	static {
		users.add(new User("tushar", "member", "tushar@123", "tushar9881"));
		users.add(new User("Ramesh", "librarian", "ramesh@654", "ramesh9881"));
	}

}
