package by.romanov.is.command;

import javax.servlet.http.HttpServletRequest;

import by.romanov.is.resource.PageManager;

public class EmptyCommand implements Command {

	@Override
	public String execute(HttpServletRequest request) {
		String page = PageManager.getProperty("page.home-page");
		return page;
	}

}
