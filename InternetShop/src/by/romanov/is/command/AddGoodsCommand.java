package by.romanov.is.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.romanov.is.entity.Goods;
import by.romanov.is.resource.PageManager;
import by.romanov.is.service.GoodsService;
import static  by.romanov.is.constants.Constants.*;

public class AddGoodsCommand implements Command {


	@Override
	public String execute(HttpServletRequest request) {
		GoodsService goodsService = new GoodsService();
		Goods goods = initGoods(request);
		goodsService.addGoods(goods);
		int numberPages = goodsService.takePageGoodsList();
		List<Goods> listGoods = goodsService.takeGoodsList(0);
		request.setAttribute(ATTR_PAGES, numberPages);
		request.setAttribute(ATTR_GOODS, listGoods);
		return PageManager.getProperty("page.admin-page-home");
	}

	/**
	 * Inits the goods.
	 *
	 * @param request the request
	 * @return the goods
	 */
	private Goods initGoods(HttpServletRequest request) {
		Goods goods = new Goods();
		Integer price = new Integer(request.getParameter(PARAM_PRICE));
		goods.setNameGoods(request.getParameter(PARAM_NAME_GOODS));
		goods.setDescription(request.getParameter(PARAM_DESCRIPTION));
		goods.setImgGoods(PARAM_IMG_LINK + request.getParameter(PARAM_IMG));
		goods.setPrice(price);
		goods.setCategory(request.getParameter(PARAM_NAME_CATEGORY));
		return goods;
	}

}
