package by.romanov.is.database.dao;

import java.util.ArrayList;
import java.util.List;

import by.romanov.is.entity.Goods;

public interface GoodsDAO {
	List<Goods> takeGoodsList(int offset);

	List<Goods> takeGoodsListCategory(int offset, String category);

	int takePageGoodsList();

	int takePageCategoryGoodsList(String category);

	ArrayList<String> takeCategory();

	boolean deleteGoods(int numberGoods);

	boolean editGoods(Goods goods);

	boolean addGoods(Goods goods);

	Goods takeGoodsDetails(int goodsId);

}
