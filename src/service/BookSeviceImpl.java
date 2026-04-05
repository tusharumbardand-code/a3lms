package service;

import java.util.ArrayList;

import dao.BookDAO;
import dao.BookDAOImpl;
import entity.Book;

public class BookSeviceImpl implements BookService {
	private BookDAO bookDAO = new BookDAOImpl();
	@Override
	public boolean addBook(Book newBook) {
		Book isPresent = bookDAO.findBookByBookId(newBook.getId());
		if (isPresent == null) {
			bookDAO.addBook(newBook);
			return true;
		}
		return false;
	}
	@Override
	public Book findBookById(int id) {
		return bookDAO.findBookByBookId(id);
	}
	@Override
	public Book findBookByName(String name) {
		return bookDAO.findBookByName(name);
	}

	@Override
	public boolean removeBook(int id) {
		return bookDAO.removeBook(id);
	}

	@Override
	public Book updateBook(int id, Book newBook) {
		Book isPresent = findBookById(id);
		if (isPresent == null) {
			return null;
		} else {
			removeBook(id);
			addBook(newBook);
			return isPresent;
		}
	}
	@Override
	public ArrayList<Book> getAllBooks() {
		return bookDAO.getAllBooks();
	}

}
