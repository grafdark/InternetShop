package by.romanov.is.command;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import static by.romanov.is.constants.Constants.*;

public class CommandFactory {
	private static final Logger LOGGER = Logger.getLogger(CommandFactory.class);

	public Command defineCommand(HttpServletRequest request) {
		Command current = new EmptyCommand();
		String action = request.getParameter(PARAM_PAGE);
		if (action == null || action.isEmpty()) {
			return current;
		}
		try {
			CommandEnum currentEnum = CommandEnum.valueOf(action.toUpperCase());
			current = currentEnum.getCurrentCommand();
		} catch (IllegalArgumentException e) {
			LOGGER.error(e);
		}
		return current;
	}
}
