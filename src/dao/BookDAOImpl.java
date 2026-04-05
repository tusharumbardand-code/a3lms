package dao;

import java.util.ArrayList;

import database.DataBaseForApp;
import entity.Book;

public class BookDAOImpl implements BookDAO {

	@Override
	public void addBook(Book newBook) {
		DataBaseForApp.books.add(newBook);
	}

	@Override
	public Book findBookByBookId(int id) {
		for (Book b : DataBaseForApp.books) {
			if (b.getId() == id) {
				return b;
			}
		}
		return null;

	}

	@Override
	public Book findBookByName(String name) {
		for (Book b : DataBaseForApp.books) {
			if (b.getTitle().equals(name)) {
				return b;
			}
		}
		return null;
	}

	@Override
	public boolean removeBook(int id) {
		Book bookToBeDeleted = findBookByBookId(id);
		if (bookToBeDeleted == null) {
			return false;
		} else {
			DataBaseForApp.books.remove(bookToBeDeleted);
			return true;
		}
	}

	@Override
	public ArrayList<Book> getAllBooks() {
		ArrayList<Book> bookList = new ArrayList<Book>(DataBaseForApp.books);
		return bookList;
	}

}
