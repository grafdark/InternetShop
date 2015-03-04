package by.romanov.is.service;

import java.util.List;

import by.romanov.is.database.dao.UserDAO;
import by.romanov.is.database.impl.UserDAOimpl;
import by.romanov.is.entity.User;
import by.romanov.is.exception.CustomException;

public class UserService {
	private UserDAO userDAO;

	public UserService() {
		userDAO = new UserDAOimpl();
	}

	public boolean checkUser(String login, String password) {
		return userDAO.checkUser(login, password);

	}

	public boolean checkBanUser(String login) {
		return userDAO.checkBanUser(login);

	}

	public String getRole(String login) {
		return userDAO.getRole(login);
	}

	public boolean registrUser(User user) throws CustomException {
		return userDAO.registrUser(user);
	}

	public User takeInfoUser(String login) {
		return userDAO.takeUserInfo(login);
	}

	public List<String> takeUserList() {
		return userDAO.takeUserList();
	}

	public boolean banUser(String login) {
		return userDAO.banUser(login);

	}
	public boolean deleteBanUser(String login){
		return userDAO.deletBanUser(login);
	}
}
