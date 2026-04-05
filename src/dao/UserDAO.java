package dao;

import java.util.ArrayList;

import entity.User;

public interface UserDAO {

	void adduser(User newUser);

	User findUserById(String userId);

	boolean removeUserById(String userId);

	ArrayList<User> getAllusers();

}
