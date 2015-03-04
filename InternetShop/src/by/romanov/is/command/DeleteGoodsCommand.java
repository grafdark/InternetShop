package by.romanov.is.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.romanov.is.entity.Goods;
import by.romanov.is.resource.PageManager;
import by.romanov.is.service.GoodsService;
import by.romanov.is.service.OrderService;
import static by.romanov.is.constants.Constants.*;

public class DeleteGoodsCommand implements Command {

	@Override
	public String execute(HttpServletRequest request) {
		int numberGoods = new Integer(request.getParameter(PARAM_ID));
		GoodsService goodsService = new GoodsService();
		OrderService orderService = new OrderService();
		
		String nameGoods = request.getParameter(PARAM_NAME_GOODS);
		List<String> users = orderService.takeUserOrder(nameGoods);

		if (!users.isEmpty()) {
			request.setAttribute(ATTR_USERS, users);
			return PageManager.getProperty("page.list_user_order");
		}
		goodsService.deleteGoods(numberGoods);
		
		int numberPages = goodsService.takePageGoodsList();
		List<Goods> listGoods = goodsService.takeGoodsList(0);
		request.setAttribute(ATTR_PAGES, numberPages);
		request.setAttribute(ATTR_GOODS, listGoods);
		return PageManager.getProperty("page.admin-page-home");
	}

}
