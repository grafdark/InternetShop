package by.romanov.is.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.romanov.is.entity.Goods;
import by.romanov.is.resource.PageManager;
import by.romanov.is.service.GoodsService;
import static by.romanov.is.constants.Constants.*;

public class PageCatalogAdminCommand implements Command {
	private static final int NUMBER_OF_PRODUCTS = 10;

	@Override
	public String execute(HttpServletRequest request) {
		GoodsService goodsService = new GoodsService();
		int numberPage = new Integer(request.getParameter(PARAM_NUMBER_PAGE));

		if (request.getParameter(PARAM_CATEGORY) != null) {
			String category = request.getParameter(PARAM_CATEGORY);
			int numberPages = goodsService.takePageCategoryGoodsList(category);
			List<Goods> listGoods = goodsService.takeGoodsListCategory(
					numberPage * NUMBER_OF_PRODUCTS - NUMBER_OF_PRODUCTS,
					category);

			request.setAttribute(ATTR_PAGES, numberPages);
			request.setAttribute(PARAM_CATEGORY, category);
			request.setAttribute(ATTR_GOODS, listGoods);
			return PageManager.getProperty("page.page-admin-category");
		} else {
			int numberPages = goodsService.takePageGoodsList();
			List<Goods> listGoods = goodsService.takeGoodsList(numberPage
					* NUMBER_OF_PRODUCTS - NUMBER_OF_PRODUCTS);

			request.setAttribute(ATTR_PAGES, numberPages);
			request.setAttribute(ATTR_GOODS, listGoods);
			return PageManager.getProperty("page.admin-page-home");
		}
	}
}
