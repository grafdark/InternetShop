package by.romanov.is.command;

import java.text.DateFormat;
import java.util.GregorianCalendar;

import javax.servlet.http.HttpServletRequest;

import by.romanov.is.entity.Goods;
import by.romanov.is.entity.Order;
import by.romanov.is.entity.User;
import by.romanov.is.resource.PageManager;
import by.romanov.is.service.OrderService;
import static by.romanov.is.constants.Constants.*;

public class OrderCommand implements Command {
		
	@Override
	public String execute(HttpServletRequest request) {
		GregorianCalendar calendar = new GregorianCalendar();
		DateFormat df = DateFormat.getDateInstance();

		OrderService orderService = new OrderService();
		Order order = new Order();
		User user = new User();
		Goods goods = new Goods();

		int quantity = new Integer(request.getParameter(PARAM_QUANTITY));
		int sum = new Integer(request.getParameter(PARAM_SUM));

		user.setLogin(request.getSession().getAttribute(ATTR_LOGIN).toString());
		order.setSum(sum * quantity);
		goods.setNameGoods(request.getParameter(PARAM_NAME_GOODS));
		order.setDateOrder(df.format(calendar.getTime()));
		order.setQuantityGoods(quantity);
		order.setPaymentOrder(request.getParameter(PARAM_PAYMENT));
		orderService.addOrder(order, user, goods);

		return PageManager.getProperty("page.order-ready");
	}

}
