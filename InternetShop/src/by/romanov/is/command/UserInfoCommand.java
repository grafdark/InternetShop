package by.romanov.is.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.romanov.is.entity.Order;
import by.romanov.is.entity.User;
import by.romanov.is.resource.LanguageManager;
import by.romanov.is.resource.PageManager;
import by.romanov.is.service.OrderService;
import by.romanov.is.service.UserService;
import static by.romanov.is.constants.Constants.*;

public class UserInfoCommand implements Command {

	@Override
	public String execute(HttpServletRequest request) {
		String lang = (String) request.getSession().getAttribute(ATTR_LANGUAGE);
		String role = request.getSession().getAttribute(ATTR_ROLE).toString();
		UserService userService = new UserService();
		OrderService orderService = new OrderService();
		if (role.equals(ROLE_ADMIN)) {
			String login = request.getParameter(ATTR_LOGIN);
			if (userService.checkBanUser(login)) {
				request.setAttribute(ATTR_USER_BANNED, login);
				request.setAttribute(ATTR_USER_IS_BAN, LanguageManager.getProperty(
						"message.user_is_ban", lang));
			}
			User user = userService.takeInfoUser(login);
			List<Order> orderUser = orderService.takeOrderUser(login);
			request.setAttribute(ATTR_USER, user);
			request.setAttribute(ATTR_ORDER, orderUser);

			return PageManager.getProperty("page.profile");
		}
		return PageManager.getProperty("page.user-info");
	}

}
