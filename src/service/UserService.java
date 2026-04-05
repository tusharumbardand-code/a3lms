package service;

import java.util.ArrayList;

import entity.User;

public interface UserService {

	boolean addUser(User user);

	User findUserById(String id);

	User removeById(String id);

	boolean updateUser(String id, User user);

	ArrayList<User> getAllusers();
}
