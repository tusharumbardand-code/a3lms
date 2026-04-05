package service;

import java.util.ArrayList;

import dao.UserDAO;
import dao.UserDAOImpl;
import entity.User;

public class UserServiceImpl implements UserService {

	private UserDAO userDAO = new UserDAOImpl();

	@Override
	public boolean addUser(User newUser) {
		for (User user : userDAO.getAllusers()) {
			if (user.getUserId().equals(newUser.getUserId())) {
				return false;
			}
		}
		userDAO.adduser(newUser);
		return true;
	}

	@Override
	public User findUserById(String id) {
		return userDAO.findUserById(id);
	}

	@Override
	public User removeById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateUser(String id, User newUser) {
		for (User user : userDAO.getAllusers()) {
			if (user.getUserId().equals(id)) {
				userDAO.removeUserById(id);
				userDAO.adduser(newUser);
				return true;
			}
		}
		return false;
	}

	@Override
	public ArrayList<User> getAllusers() {
		return userDAO.getAllusers();
	}

}
