package by.romanov.is.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import by.romanov.is.resource.PageManager;
import static by.romanov.is.constants.Constants.*;

public class ExitButtonCommand implements Command {

	@Override
	public String execute(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute(ATTR_LOGIN);
		session.removeAttribute(ATTR_ROLE);
		return PageManager.getProperty("page.home-page");
	}

}
