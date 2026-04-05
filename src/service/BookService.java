package service;

import java.util.ArrayList;

import entity.Book;

public interface BookService {

	boolean addBook(Book newBook);

	Book findBookById(int id);

	Book findBookByName(String name);

	boolean removeBook(int id);

	Book updateBook(int id, Book newBook);
	
	ArrayList<Book> getAllBooks();

}
