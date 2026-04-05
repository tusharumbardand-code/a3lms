package dao;

import java.util.ArrayList;

import database.DataBaseForApp;
import entity.User;

public class UserDAOImpl implements UserDAO {

	@Override
	public void adduser(User newUser) {

		DataBaseForApp.users.add(newUser);

	}

	@Override
	public User findUserById(String userId) {
		for (User user : DataBaseForApp.users) {
			if (user.getUserId().equals(userId)) {
				return user;
			}
		}
		return null;
	}

	@Override
	public boolean removeUserById(String userId) {
		User isPresent = findUserById(userId);
		if (isPresent == null) {
			return false;
		}
		DataBaseForApp.users.remove(isPresent);
		return true;
	}

	@Override
	public ArrayList<User> getAllusers() {
		// TODO Auto-generated method stub
		return DataBaseForApp.users;
	}

}
