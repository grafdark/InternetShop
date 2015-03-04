package by.romanov.is.command;

import javax.servlet.http.HttpServletRequest;

import by.romanov.is.entity.Goods;
import by.romanov.is.resource.LanguageManager;
import by.romanov.is.resource.PageManager;
import by.romanov.is.service.GoodsService;
import static by.romanov.is.constants.Constants.*;

public class MoreGoodsCommand implements Command {

	@Override
	public String execute(HttpServletRequest request) {
		String lang = (String) request.getSession().getAttribute(ATTR_LANGUAGE);
		if (isLogin(request) != null) {
			GoodsService goodsService = new GoodsService();
			Integer numberGoods = new Integer(request.getParameter(PARAM_ID));
			Goods goods = goodsService.takeGoodsDetails(numberGoods);
			request.setAttribute(ATTR_GOODS, goods);

		} else {
			request.setAttribute(ATTR_MESSAGE_LOG_IN,
					LanguageManager.getProperty("message.log_in", lang));
			return PageManager.getProperty("page.login");
		}
		return PageManager.getProperty("page.goods-description");
	}

	private Object isLogin(HttpServletRequest request) {
		return request.getSession().getAttribute(ATTR_LOGIN);
	}

}
