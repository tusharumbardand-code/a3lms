package view;

import entity.Book;
import service.BookService;
import service.BookSeviceImpl;
import util.Input;

public class BookView {

	private static BookService bookService = new BookSeviceImpl();

	public static void main(String[] args) {
		while (true) {
			System.out.println(
					"1.ADD BOOK\n2.SEARCH BOOK BY NAME\n3.SEARCH BOOK BY ID\n4.REMOVE BOOK BY ID\n5.UPDATE BOOK\n6.SHOW ALL BOOK\n7.EXIT");
			int op = Input.getScanner().nextInt();
			switch (op) {
			case 1: {
				Book newBook = inputForBookAdd();
				boolean isAdded = bookService.addBook(newBook);
				if (isAdded) {
					System.out.println("BOOK IS ADDED");
				} else {
					System.out.println("BOOK WITH SAME ID IS PRESENT");
				}
			}
				break;
			case 2: {
				Input.getScanner().nextLine();
                System.out.println("ENTER BOOK NAME");
				String name = Input.getScanner().nextLine();
				Book book = bookService.findBookByName(name);
				if (book == null) {
					System.out.println("BOOK WITH GIVEN ID IS NOT PRESNET");
				} else {
					System.out.println(book);
				}
			}
				break;

			case 3: {
				System.out.println("ENTER ID");
				int id = Input.getScanner().nextInt();
				Book book = bookService.findBookById(id);
				if (book == null) {
					System.out.println("BOOK WITH GIVEN ID IS NOT PRESNET");
				} else {
					System.out.println(book);

				}
			}
				break;
			case 4: {
				System.out.println("ENTER ID");
				int id = Input.getScanner().nextInt();
				Book isPresnt = bookService.findBookById(id);
				if (isPresnt == null) {
					System.out.println("BOOK WITH GIVEN ID IS NOT PRESNET");
				} else {
					bookService.removeBook(id);
	
					System.out.println("BOOK REMOVED"+isPresnt);
					
				}
			}
				break;
			case 5: {
				System.out.println("ENTER ID");
				int id = Input.getScanner().nextInt();
				Book isPresent = bookService.findBookById(id);
				if (isPresent == null) {
					System.out.println("BOOK WITH GIVEN ID IS NOT PRESNET");
				} else {
					bookService.removeBook(id);
					System.out.println(isPresent);
					Book newBook = inputForBookAdd();
					bookService.addBook(newBook);
					System.out.println("BOOK UPDATED");
				}
			}
				break;
			case 6: {
				showAllBooks();
			}
				break;
			case 7: {
				System.exit(0);
			}
			}
		}
	}

	public static Book inputForBookAdd() {
		Input.getScanner().nextLine();
		System.out.println("ENTER BOOK NAME");
		String name = Input.getScanner().nextLine();
		System.out.println("ENTER AUTHOR");
		String author = Input.getScanner().nextLine();
		System.out.println("ENTER ID");
		int id = Input.getScanner().nextInt();
		System.out.println("ENTER RATING");
		double rating = Input.getScanner().nextDouble();
		Book book = new Book(name, author, id, rating);
		return book;
	}

	public static void showAllBooks() {
		for (Book book : bookService.getAllBooks()) {
			System.out.println(book);
		}
	}

}
