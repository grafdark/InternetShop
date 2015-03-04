package by.romanov.is.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.romanov.is.entity.Goods;
import by.romanov.is.resource.PageManager;
import by.romanov.is.service.GoodsService;
import static by.romanov.is.constants.Constants.*;

public class HomePageCommand implements Command {

	@Override
	public String execute(HttpServletRequest request) {

		if (isEntry(request) != null) {
			return PageManager.getProperty("page.login");
		} else if (isRegistr(request) != null) {
			return PageManager.getProperty("page.registration");
		}

		GoodsService goodsService = new GoodsService();
		int numberPages = goodsService.takePageGoodsList();
		List<Goods> listGoods = goodsService.takeGoodsList(0);
		request.setAttribute(ATTR_PAGES, numberPages);
		request.setAttribute(ATTR_GOODS, listGoods);
		if (isRole(request) != null) {
			String role = isRole(request).toString();
			if (ROLE_ADMIN.equals(role)) {
				return PageManager.getProperty("page.admin-page-home");
			} else if (ROLE_USER.equals(role)) {
				return PageManager.getProperty("page.catalog");
			}
		}
		return PageManager.getProperty("page.home-page");
	}

	private String isEntry(HttpServletRequest request) {
		return request.getParameter(PARAM_LOGIN);
	}

	private String isRegistr(HttpServletRequest request) {
		return request.getParameter(PARAM_REGISTR);
	}

	private Object isRole(HttpServletRequest request) {
		return request.getSession().getAttribute(ATTR_ROLE);
	}
}
