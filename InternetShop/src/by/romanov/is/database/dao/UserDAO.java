package by.romanov.is.database.dao;

import java.util.List;

import by.romanov.is.entity.User;
import by.romanov.is.exception.CustomException;

public interface UserDAO {
	boolean checkUser(String login, String password);

	boolean registrUser(User user) throws CustomException;

	boolean banUser(String login);

	boolean deletBanUser(String login);

	boolean checkBanUser(String login);

	String getRole(String login);

	User takeUserInfo(String login);

	List<String> takeUserList();

}
