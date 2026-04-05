package view;

import entity.Book;
import entity.User;
import service.BookService;
import service.BookSeviceImpl;
import service.UserService;
import service.UserServiceImpl;
import util.Input;

public class Driver {

	private static UserService userService = new UserServiceImpl();
	private static BookService bookService = new BookSeviceImpl();

	public static void main(String[] args) {
		runApp();
	}

	public static void runApp() {
		System.out.println("1.LOGIN \n2.SIGNIN");
		int op = Input.getScanner().nextInt();
		if (op == 1) {
			logIn();
		} else if (op == 2) {
			signIn();
		} else {
			System.out.println("INVALID INPUT");
		}
	}

	private static void signIn() {
		Input.getScanner().nextLine();
		System.out.println("ENTER NAME");
		String name = Input.getScanner().nextLine();
		System.out.println("ENTER USER ID");
		String userId = Input.getScanner().nextLine();
		System.out.println("CREATE PASSWORD");
		String password = Input.getScanner().nextLine();
		System.out.println("SELECT TYPE");
		String tyep = Input.getScanner().nextLine();
		User newUser = new User(name, tyep, userId, password);
		User isPresent = userService.findUserById(userId);
		if (isPresent == null) {
			userService.addUser(newUser);
		} else {
			System.out.println("USE DIFF. USER ID");
		}

	}

	private static void logIn() {
		Input.getScanner().nextLine();
		System.out.println("ENTER USERID");
		String userId = Input.getScanner().nextLine();
		User user = userService.findUserById(userId);
		if (user == null) {
			System.out.println("USER NOT PRESENT");
			return;
		} else {
			System.out.println("ENTER PASSWORD");
			String password = Input.getScanner().nextLine();
			if (user.getPassword().equals(password)) {
				String type = user.getType();
				if (type.equalsIgnoreCase("member")) {
					memberView(user);
				} else {
					librarianView();
				}
			} else {
				System.out.println("WRONG PASSWORD");
			}
		}
	}

	private static void librarianView() {

		System.out.println("librarianView");

	}

	private static void memberView(User user) {
		while (true) {
			System.out.println(
					"1.ALL BOOKS \n2.BORROW BOOK \n3.RETURN BOOK \n4.SORT BY ID \n5.SORT BY RATING \n6.UPDATE INFO \n7.BOOKS OF MEMBERS \n8.INFO \n9.EXIT");

			int op = Input.getScanner().nextInt();
			switch (op) {
			case 1: {
				BookView.showAllBooks();
			}
				break;
			case 2: {
				BorrowBook(user);
			}
				break;

			case 3: {
				returnBook(user);
			}
				break;
			case 4: {
				bookService.getAllBooks().stream().sorted((a, b) -> a.getId() - b.getId())
						.forEach(book -> System.out.println(book));
			}
				break;
			case 5: {
				bookService.getAllBooks().stream().sorted((a, b) -> Double.compare(b.getRating(), a.getRating()))
						.forEach(book -> System.out.println(book));
			}
				break;
			case 6: {
				user = updateUserInfo(user);
			}
				break;
			case 7: {
				System.out.println("====BOOKS OF USER====");
				for (Book b : user.getUsersBookList()) {
					System.out.println(b);
				}
				System.out.println("============");
			}
				break;
			case 8: {
				System.out.println(user);
			}
				break;
			case 9: {
				return;
			}

			}
		}

	}

	private static User updateUserInfo(User user) {
		System.out.println(user);
		Input.getScanner().nextLine();
		System.out.println("ENTER NAME");
		String name = Input.getScanner().nextLine();
		System.out.println("CREATE PASSWORD");
		String password = Input.getScanner().nextLine();
		User newUser = new User(name, user.getType(), user.getUserId(), password);
		userService.updateUser(user.getUserId(), newUser);
		System.out.println("INFO IS UPDATED");
		return newUser;

	}

	private static void returnBook(User user) {

		System.out.println("ENTER BOOK ID");
		int bookId = Input.getScanner().nextInt();
		for (Book book : user.getUsersBookList()) {
			if (book.getId() == bookId) {
				user.getUsersBookList().remove(book);
				bookService.addBook(book);
				System.out.println("BOOK RETURNED");
				return;
			}
		}
		System.out.println("BOOK WITH GIVEN ID IS NOT PRESENT");

	}

	private static void BorrowBook(User user) {
		Input.getScanner().nextLine();
		System.out.println("ENTER BOOK NAME");
		String bookName = Input.getScanner().nextLine();
		Book isPresent = bookService.findBookByName(bookName);
		if (isPresent == null) {
			System.out.println("BOOK IS NOT PRESENT");
			return;
		} else {
			bookService.removeBook(isPresent.getId());
			user.getUsersBookList().add(isPresent);
			System.out.println("BOOK BORROWEd");
		}

	}

}
//users.add(new User("tushar", "member", "tushar@123", "tushar9881"));
//users.add(new User("Ramesh", "librarian", "ramesh@654", "ramesh9881"));