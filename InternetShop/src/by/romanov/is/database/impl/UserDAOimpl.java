package by.romanov.is.database.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import by.romanov.is.database.dao.UserDAO;
import by.romanov.is.database.utils.DAOUtils;
import by.romanov.is.entity.User;
import by.romanov.is.exception.CustomException;
import by.romanov.is.pool.Pool;

public class UserDAOimpl implements UserDAO {
	private static final Logger LOGGER = Logger.getLogger(UserDAOimpl.class);
	private static final String SQL_QUERY_CHECK_USER = "SELECT * FROM user WHERE login = ? AND password = ?";
	private static final String SQL_QUERY_REGISTR_USER = "INSERT INTO user (login, password, role)   VALUES (?,?,?)";
	private static final String SQL_QUERY_BAN_USER = "INSERT INTO blacklist (user, ban)   VALUES (?,?)";
	private static final String SQL_QUERY_CHECK_BAN_USER = "SELECT * FROM  blacklist where user = ?";
	private static final String SQL_QUERY_GET_ROLE = "SELECT role FROM USER WHERE login = ?";
	private static final String SQL_QUERY_TAKE_USER_INFO = "SELECT login, first_name, email, last_name, telephone FROM user JOIN user_description ON user.user_id = user_description.id";
	private static final String SQL_QUERY_ADD_USER_INFO = "INSERT INTO user_description  (id, first_name, email, last_name, telephone ) VALUES ((SELECT user_id from user where login=?),?,?,?,?)";
	private static final String SQL_QUERY_DELETE_BAN_USER = "DELETE FROM blacklist WHERE user=?";

	public boolean checkUser(String login, String password) {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Connection connection = null;
		try {
			connection = Pool.getInstance().getResource();
			preparedStatement = connection
					.prepareStatement(SQL_QUERY_CHECK_USER);
			preparedStatement.setString(1, login);
			preparedStatement.setString(2, password);
			resultSet = preparedStatement.executeQuery();
			return resultSet.next();
		} catch (SQLException e) {
			LOGGER.error("SQLException", e);
			return false;
		} finally {
			DAOUtils.closeStatement(preparedStatement);
			Pool.getInstance().returnResources(connection);
		}
		
	}

	@Override
	public boolean registrUser(User user) throws CustomException {
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		boolean flag = false;
		try {
			connection = Pool.getInstance().getResource();
			preparedStatement = connection
					.prepareStatement(SQL_QUERY_REGISTR_USER);
			preparedStatement.setString(1, user.getLogin());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getAccess());
			preparedStatement.executeUpdate();
			preparedStatement.close();

			preparedStatement = connection
					.prepareStatement(SQL_QUERY_ADD_USER_INFO);
			preparedStatement.setString(1, user.getLogin());
			preparedStatement.setString(2, user.getFirstName());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, user.getLastName());
			preparedStatement.setString(5, user.getTelephone());
			preparedStatement.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			throw new CustomException(e);	
		} finally {
			DAOUtils.closeStatement(preparedStatement);
			Pool.getInstance().returnResources(connection);
		}
		return flag;
	}

	@Override
	public boolean banUser(String login) {
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		try {
			connection = Pool.getInstance().getResource();
			preparedStatement = connection.prepareStatement(SQL_QUERY_BAN_USER);
			preparedStatement.setString(1, login);
			preparedStatement.setString(2, "true");
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.error("SQLException", e);
			return false;
		} finally {
			DAOUtils.closeStatement(preparedStatement);
			Pool.getInstance().returnResources(connection);
		}
		return true;
	}

	@Override
	public boolean checkBanUser(String login) {
		PreparedStatement preparedStatement;
		Connection connection = null;
		try {
			connection = Pool.getInstance().getResource();
			preparedStatement = connection
					.prepareStatement(SQL_QUERY_CHECK_BAN_USER);
			preparedStatement.setString(1, login);
			ResultSet resultSet = preparedStatement.executeQuery();
			return resultSet.next();
		} catch (SQLException e) {
			LOGGER.error("SQLException", e);
			return false;
		} finally {
			Pool.getInstance().returnResources(connection);
		}
	}

	@Override
	public String getRole(String login) {
		Connection connection = null;
		String role = null;
		PreparedStatement preparedStatement = null;
		connection = Pool.getInstance().getResource();
		try {
			preparedStatement = connection.prepareStatement(SQL_QUERY_GET_ROLE);
			preparedStatement.setString(1, login);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				role = resultSet.getString(1);
			}
		} catch (SQLException e) {
			LOGGER.error("SQLException", e);
		} finally {
			DAOUtils.closeStatement(preparedStatement);
			Pool.getInstance().returnResources(connection);
		}
		return role;
	}

	@Override
	public User takeUserInfo(String login) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		connection = Pool.getInstance().getResource();
		User user = new User();
		try {
			preparedStatement = connection
					.prepareStatement(SQL_QUERY_TAKE_USER_INFO);
			ResultSet resultSet = preparedStatement
					.executeQuery(SQL_QUERY_TAKE_USER_INFO);
			while (resultSet.next()) {
				String loginUser = resultSet.getString(1);
				if (login.equals(loginUser)) {
					user.setLogin(loginUser);
					user.setFirstName(resultSet.getString(2));
					user.setEmail(resultSet.getString(3));
					user.setLastName(resultSet.getString(4));
					user.setTelephone(resultSet.getString(5));
				}
			}
		} catch (SQLException e) {
			LOGGER.error("SQLException", e);
		} finally {
			DAOUtils.closeStatement(preparedStatement);
			Pool.getInstance().returnResources(connection);
		}
		return user;
	}

	@Override
	public List<String> takeUserList() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		List<String> listUser = new ArrayList<String>();

		try {
			connection = Pool.getInstance().getResource();
			preparedStatement = connection
					.prepareStatement(SQL_QUERY_TAKE_USER_INFO);
			ResultSet resultSet = preparedStatement
					.executeQuery(SQL_QUERY_TAKE_USER_INFO);
			while (resultSet.next()) {
				String login = resultSet.getString(1);
				listUser.add(login);

			}
		} catch (SQLException e) {
			LOGGER.error("SQLException", e);
		} finally {
			DAOUtils.closeStatement(preparedStatement);
			Pool.getInstance().returnResources(connection);

		}
		return listUser;
	}

	@Override
	public boolean deletBanUser(String login) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = Pool.getInstance().getResource();
			preparedStatement = connection
					.prepareStatement(SQL_QUERY_DELETE_BAN_USER);
			preparedStatement.setString(1, login);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.error("SQLException", e);
			return false;
		} finally {
			DAOUtils.closeStatement(preparedStatement);
			Pool.getInstance().returnResources(connection);
		}
		return true;
	}
}
