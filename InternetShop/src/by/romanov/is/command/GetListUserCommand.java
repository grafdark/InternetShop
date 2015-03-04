package by.romanov.is.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.romanov.is.resource.PageManager;
import by.romanov.is.service.UserService;
import static by.romanov.is.constants.Constants.*;

public class GetListUserCommand implements Command {

	@Override
	public String execute(HttpServletRequest request) {
		UserService userService = new UserService();
		List<String> userList = userService.takeUserList();
		request.setAttribute(ATTR_USER_LIST, userList);

		return PageManager.getProperty("page.list-user");
	}

}
