package by.romanov.is.database.utils;

import java.sql.SQLException;

import java.sql.Statement;

import org.apache.log4j.Logger;

public class DAOUtils {
	private static final Logger LOGGER = Logger.getLogger(DAOUtils.class);

	public static void closeStatement(Statement statement) {
		try {

			if (statement != null) {
				statement.close();
			}
		} catch (SQLException e) {
			LOGGER.error("statement not closed", e);
		}
	}
}
