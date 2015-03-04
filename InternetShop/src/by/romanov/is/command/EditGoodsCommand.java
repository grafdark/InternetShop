package by.romanov.is.command;

import javax.servlet.http.HttpServletRequest;

import by.romanov.is.entity.Goods;
import by.romanov.is.resource.PageManager;
import by.romanov.is.service.GoodsService;
import static by.romanov.is.constants.Constants.*;

public class EditGoodsCommand implements Command {

	@Override
	public String execute(HttpServletRequest request) {
		Goods goods = initGoods(request);
		GoodsService goodsService = new GoodsService();
		Integer numberGoods = new Integer(request.getParameter(PARAM_ID_GOODS));
		goodsService.editGoods(goods);	
		goods = goodsService.takeGoodsDetails(numberGoods);
		request.setAttribute(ATTR_GOODS, goods);
		return PageManager.getProperty("page.goods-description");
	}

	private Goods initGoods(HttpServletRequest request) {
		Integer numberGoods = new Integer(request.getParameter(PARAM_ID_GOODS));
		Integer price = new Integer(request.getParameter(PARAM_PRICE));
		Goods goods = new Goods();
		goods.setNumberGoods(numberGoods);
		goods.setNameGoods(request.getParameter(PARAM_NAME_GOODS));
		goods.setDescription(request.getParameter(PARAM_DESCRIPTION));
		goods.setImgGoods(PARAM_IMG_LINK + request.getParameter(PARAM_IMG));
		goods.setPrice(price);
		return goods;
	}

}
