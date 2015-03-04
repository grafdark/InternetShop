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

public class PayOrderCommand implements Command {


	@Override
	public String execute(HttpServletRequest request) {

		String lang = (String) request.getSession().getAttribute(ATTR_LANGUAGE);

		OrderService orderService = new OrderService();
		UserService userService = new UserService();
		String login = (String) request.getSession().getAttribute(ATTR_LOGIN);
		if (ATTR_PAID_ORDER != null) {
			Integer numberOrder = new Integer(
					request.getParameter(ATTR_NUMBER_ORDER));
			orderService.payOrder(numberOrder);
			request.setAttribute(ATTR_PAID,
					LanguageManager.getProperty("message.paid_order", lang));
		}
		User user = userService.takeInfoUser(login);
		List<Order> orderUser = orderService.takeOrderUser(login);
		request.setAttribute(ATTR_USER, user);
		request.setAttribute(ATTR_ORDER, orderUser);

		return PageManager.getProperty("page.user-info");
	}

}
