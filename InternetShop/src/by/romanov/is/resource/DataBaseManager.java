package by.romanov.is.resource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

public class DataBaseManager {
	private static final Logger LOGGER = Logger
			.getLogger(DataBaseManager.class);
	private static final ResourceBundle DB_BUNDLE = ResourceBundle
			.getBundle("resource.database");

	public Connection getConnection(Properties properties) {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(
					DB_BUNDLE.getString("db_path"), properties);
		} catch (SQLException e) {
			LOGGER.fatal("SQLException: " + e);
			throw new ExceptionInInitializerError();
		}

		return connection;
	}
}
