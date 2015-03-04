package by.romanov.is.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.romanov.is.entity.Goods;
import by.romanov.is.resource.PageManager;
import by.romanov.is.service.GoodsService;
import by.romanov.is.service.OrderService;
import static by.romanov.is.constants.Constants.*;

public class EditGoodsPageCommand implements Command {

	@Override
	public String execute(HttpServletRequest request) {
		Goods goods;
		GoodsService goodsService = new GoodsService();
		OrderService orderService = new OrderService();
		Integer numberGoodsPage = new Integer(request.getParameter(PARAM_ID));
		String nameGoods = request.getParameter(PARAM_NAME_GOODS);
		List<String> users = orderService.takeUserOrder(nameGoods);

		if (!users.isEmpty()) {
			request.setAttribute(ATTR_USERS, users);
			return PageManager.getProperty("page.list_user_order");
		}

		goods = goodsService.takeGoodsDetails(numberGoodsPage);
		request.setAttribute(ATTR_GOODS, goods);

		return PageManager.getProperty("page.edit-goods");
	}
}
