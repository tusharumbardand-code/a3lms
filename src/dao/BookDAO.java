package dao;

import java.util.ArrayList;

import entity.Book;

public interface BookDAO {

	void addBook(Book newBook);

	Book findBookByBookId(int id);

	Book findBookByName(String name);

	boolean removeBook(int id);
	
	ArrayList<Book> getAllBooks();

}
