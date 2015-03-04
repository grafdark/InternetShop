package by.romanov.is.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.romanov.is.entity.Order;
import by.romanov.is.entity.User;
import by.romanov.is.resource.PageManager;
import by.romanov.is.service.OrderService;
import by.romanov.is.service.UserService;
import static by.romanov.is.constants.Constants.*;

public class ProfileCommand implements Command {

	@Override
	public String execute(HttpServletRequest request) {
		UserService userService = new UserService();
		OrderService orderService = new OrderService();
		String login = (String) request.getSession().getAttribute(ATTR_LOGIN);
		User user = userService.takeInfoUser(login);
		List<Order> orderUser = orderService.takeOrderUser(login);
		request.setAttribute(ATTR_USER, user);
		request.setAttribute(ATTR_ORDER, orderUser);

		return PageManager.getProperty("page.user-info");

	}
}
