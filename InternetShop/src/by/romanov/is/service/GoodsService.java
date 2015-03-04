package by.romanov.is.service;

import java.util.ArrayList;
import java.util.List;

import by.romanov.is.database.dao.GoodsDAO;
import by.romanov.is.database.impl.GoodsDAOimpl;
import by.romanov.is.entity.Goods;

public class GoodsService {
	private GoodsDAO goodsDAO;

	public GoodsService() {
		goodsDAO = new GoodsDAOimpl();
	}

	public List<Goods> takeGoodsList(int offset) {
		return goodsDAO.takeGoodsList(offset);
	}

	public ArrayList<String> takeCategory() {
		return goodsDAO.takeCategory();
	}

	public boolean deleteGoods(int numberGoods) {
		return goodsDAO.deleteGoods(numberGoods);
	}

	public boolean editGoods(Goods goods) {
		return goodsDAO.editGoods(goods);
	}

	public boolean addGoods(Goods goods) {
		return goodsDAO.addGoods(goods);
	}

	public Goods takeGoodsDetails(int goodsId) {
		return goodsDAO.takeGoodsDetails(goodsId);

	}

	public int takePageGoodsList() {
		return goodsDAO.takePageGoodsList();
	}

	public List<Goods> takeGoodsListCategory(int offset, String category) {
		return goodsDAO.takeGoodsListCategory(offset, category);
	}

	public int takePageCategoryGoodsList(String category) {
		return goodsDAO.takePageCategoryGoodsList(category);
	}
}
