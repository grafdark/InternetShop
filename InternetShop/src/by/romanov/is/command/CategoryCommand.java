package by.romanov.is.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.romanov.is.entity.Goods;
import by.romanov.is.resource.PageManager;
import by.romanov.is.service.GoodsService;
import static by.romanov.is.constants.Constants.*;

public class CategoryCommand implements Command {

	@Override
	public String execute(HttpServletRequest request) {

		Integer numberCategory = new Integer(request.getParameter(PARAM_NUMBER));
		GoodsService goodsService = new GoodsService();
		List<String> category = goodsService.takeCategory();
		int numberPages = goodsService.takePageCategoryGoodsList(category
				.get(numberCategory));

		List<Goods> goods = goodsService.takeGoodsListCategory(0,
				category.get(numberCategory));

		request.setAttribute(ATTR_CATEGORY, category.get(numberCategory));
		request.setAttribute(ATTR_PAGES, numberPages);
		request.setAttribute(ATTR_GOODS, goods);

		if (isRole(request) != null) {
			String role = isRole(request)
					.toString();
			if (isRoleAdmin(role)) {
				return PageManager.getProperty("page.page-admin-category");
			}
		}
		return PageManager.getProperty("page.page-category");
	}

	private Object isRole(HttpServletRequest request) {
		return request.getSession().getAttribute(ATTR_ROLE);
	}

	private boolean isRoleAdmin(String role) {
		return role.equals(ROLE_ADMIN);
	}
}
