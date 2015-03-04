package by.romanov.is.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.romanov.is.entity.Order;
import by.romanov.is.entity.User;
import by.romanov.is.resource.LanguageManager;
import by.romanov.is.resource.PageManager;
import by.romanov.is.service.OrderService;
import by.romanov.is.service.UserService;
import static  by.romanov.is.constants.Constants.*; 

public class ActionBanCommand implements Command {

	@Override
	public String execute(HttpServletRequest request) {
		String lang = (String) request.getSession().getAttribute(ATTR_LANGUAGE);
		UserService userService = new UserService();
		OrderService orderService = new OrderService();

		String action = request.getParameter(PARAM_ACTION);
		String login = request.getParameter(PARAM_LOGIN);

		User user = userService.takeInfoUser(login);
		if (ACTION_CREATE_BAN.equals(action)) {
			userService.banUser(login);

		} else if (ACTION_DELETE_BAN.equals(action)) {
			userService.deleteBanUser(login);
		}
		List<Order> orderUser = orderService.takeOrderUser(login);
		request.setAttribute(ATTR_ORDER, orderUser);
		request.setAttribute(ATTR_USER, user);
		if (userService.checkBanUser(login)) {
			request.setAttribute(ATTR_USER_BANNED, login);
			request.setAttribute(ATTR_USER_IS_BAN,
					LanguageManager.getProperty("message.user_is_ban", lang));
		}
		return PageManager.getProperty("page.profile");
	}
}
