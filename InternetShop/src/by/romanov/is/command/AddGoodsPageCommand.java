package by.romanov.is.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import by.romanov.is.resource.PageManager;
import by.romanov.is.service.GoodsService;
import static by.romanov.is.constants.Constants.*;

public class AddGoodsPageCommand implements Command {

	@Override
	public String execute(HttpServletRequest request) {
		GoodsService goodsService = new GoodsService();
		ArrayList<String> category = goodsService.takeCategory();
		request.setAttribute(PARAM_CATEGORY, category);
		return PageManager.getProperty("page.add-goods");
	}

}
