package entity;

import java.util.ArrayList;
import java.util.Objects;

public class User {

	private String name;
	private String type;
	private String userId;
	private String password;
	private ArrayList<Book> usersBookList = new ArrayList<>();

	public ArrayList<Book> getUsersBookList() {
		return usersBookList;
	}

	public void setUsersBookList(ArrayList<Book> usersBookList) {
		this.usersBookList = usersBookList;
	}

	public User(String name, String type, String userId, String password) {
		super();
		this.name = name;
		this.type = type;
		this.userId = userId;
		this.password = password;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", type=" + type + ", userId=" + userId + ", password=" + password + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, password, type, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(name, other.name) && Objects.equals(password, other.password)
				&& Objects.equals(type, other.type) && Objects.equals(userId, other.userId);
	}

}
