package by.romanov.is.command;

import javax.servlet.http.HttpServletRequest;

import by.romanov.is.resource.PageManager;
import static by.romanov.is.constants.Constants.*;

public class LanguageCommand implements Command {

	@Override
	public String execute(HttpServletRequest request) {
		HomePageCommand homePageCommand = new HomePageCommand();
		String strLanguage = request.getParameter(LANGUAGE);

		if (strLanguage.equals(LANGUAGE_EN)) {
			request.getSession().setAttribute(LANGUAGE, LANGUAGE_EN);
			if (isRole(request) != null) {
				return homePageCommand.execute(request);
			}
		} else if (strLanguage.equals(LANGUAGE_RU)) {
			request.getSession().setAttribute(LANGUAGE, LANGUAGE_RU);
			if (isRole(request) != null) {
				return homePageCommand.execute(request);
			}
		}
		return PageManager.getProperty("page.home-page");
	}

	private Object isRole(HttpServletRequest request) {
		return request.getSession().getAttribute(ATTR_ROLE);
	}
}
