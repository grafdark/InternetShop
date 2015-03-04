package by.romanov.is.database.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import by.romanov.is.database.dao.GoodsDAO;
import by.romanov.is.database.utils.DAOUtils;
import by.romanov.is.entity.Goods;
import by.romanov.is.pool.Pool;

public class GoodsDAOimpl implements GoodsDAO {
	private static final Logger LOGGER = Logger.getLogger(GoodsDAOimpl.class);
	private static final String SQL_QUERY_TAKE_GOODS = "SELECT product_name, description, price, img, number_goods FROM goods LIMIT 10 OFFSET ?";
	private static final String SQL_QUERY_COUNT_GOODS = "SELECT COUNT(number_goods) FROM goods";
	private static final String SQL_QUERY_TAKE_GOODS_CATEGORY = "SELECT categoryName, product_name, description, price, img, number_goods FROM category JOIN goods ON category.id = goods.category_number WHERE categoryName=? LIMIT 10 OFFSET ?";
	private static final String SQL_QUERY_COUNT_GOODS_CATEGORY = "SELECT COUNT(number_goods) FROM goods JOIN category ON category.id = goods.category_number WHERE categoryName=?";
	private static final String SQL_QUERY_TAKE_GATEGORY = "SELECT categoryName FROM category";
	private static final String SQL_QUERY_DELETE_GOODS = "DELETE from goods where number_goods = ?";
	private static final String SQL_QUERY_EDIT_GOODS = "UPDATE goods SET product_name = ?, description = ?, price=?, img=? WHERE number_goods=?";
	private static final String SQL_QUERY_ADD_GOODS = "INSERT INTO goods (product_name, category_number, description, price, img) VALUES (?,(SELECT id FROM category where categoryName=?),?,?,?)";
	private static final String SQL_QUERY_TAKE_GOODS_DETAILS = "SELECT * FROM goods WHERE number_goods =?";

	@Override
	public List<Goods> takeGoodsList(int offset) {
		List<Goods> goods = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = Pool.getInstance().getResource();
			preparedStatement = connection
					.prepareStatement(SQL_QUERY_TAKE_GOODS);
			preparedStatement.setInt(1, offset);
			ResultSet resultSet = preparedStatement.executeQuery();
			goods = initGoodsList(resultSet);
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			DAOUtils.closeStatement(preparedStatement);
			Pool.getInstance().returnResources(connection);

		}
		return goods;
	}

	private List<Goods> initGoodsList(ResultSet resultSet) {
		List<Goods> goodsList = new ArrayList<Goods>();
		try {
			while (resultSet.next()) {
				Goods goods = new Goods();
				goods.setNameGoods(resultSet.getString(1));
				goods.setDescription(resultSet.getString(2));
				goods.setPrice(resultSet.getInt(3));
				goods.setImgGoods(resultSet.getString(4));
				goods.setNumberGoods(resultSet.getInt(5));
				goodsList.add(goods);
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return goodsList;
	}

	public int takePageGoodsList() {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Connection connection = null;
		int numberPage = 0;
		try {
			connection = Pool.getInstance().getResource();
			preparedStatement = connection
					.prepareStatement(SQL_QUERY_COUNT_GOODS);
			resultSet = preparedStatement.executeQuery();
			numberPage = initNumberPage(resultSet);
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			DAOUtils.closeStatement(preparedStatement);
			Pool.getInstance().returnResources(connection);
		}
		return numberPage;
	}

	private int initNumberPage(ResultSet resultSet) throws SQLException {
		int number = 0;
		while (resultSet.next()) {
			number = resultSet.getInt(1);
		}
		if (number % 10 != 0) {
			return number / 10 + 1;
		} else {
			return number / 10;
		}
	}

	@Override
	public List<Goods> takeGoodsListCategory(int offset, String category) {
		List<Goods> goods = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = Pool.getInstance().getResource();
			preparedStatement = connection
					.prepareStatement(SQL_QUERY_TAKE_GOODS_CATEGORY);
			preparedStatement.setString(1, category);
			preparedStatement.setInt(2, offset);
			ResultSet resultSet = preparedStatement.executeQuery();
			goods = initGoodsListCategory(resultSet);
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			DAOUtils.closeStatement(preparedStatement);
			Pool.getInstance().returnResources(connection);
		}
		return goods;
	}

	private List<Goods> initGoodsListCategory(ResultSet resultSet) {
		List<Goods> goodsList = new ArrayList<Goods>();
		try {
			while (resultSet.next()) {
				Goods goods = new Goods();
				goods.setCategory(resultSet.getString(1));
				goods.setNameGoods(resultSet.getString(2));
				goods.setDescription(resultSet.getString(3));
				goods.setPrice(resultSet.getInt(4));
				goods.setImgGoods(resultSet.getString(5));
				goods.setNumberGoods(resultSet.getInt(6));
				goodsList.add(goods);
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return goodsList;
	}

	@Override
	public int takePageCategoryGoodsList(String category) {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Connection connection = null;
		int numberPage = 0;
		try {
			connection = Pool.getInstance().getResource();
			preparedStatement = connection
					.prepareStatement(SQL_QUERY_COUNT_GOODS_CATEGORY);
			preparedStatement.setString(1, category);
			resultSet = preparedStatement.executeQuery();
			numberPage = initNumberPage(resultSet);
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			DAOUtils.closeStatement(preparedStatement);
			Pool.getInstance().returnResources(connection);
		}
		return numberPage;
	}

	@Override
	public ArrayList<String> takeCategory() {
		ArrayList<String> cataloge = new ArrayList<String>();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Connection connection = null;
		try {
			connection = Pool.getInstance().getResource();
			preparedStatement = connection
					.prepareStatement(SQL_QUERY_TAKE_GATEGORY);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String category = resultSet.getString("categoryName");
				cataloge.add(category);
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			DAOUtils.closeStatement(preparedStatement);
			Pool.getInstance().returnResources(connection);
		}
		return cataloge;
	}

	@Override
	public boolean deleteGoods(int numberGoods) {
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		try {
			connection = Pool.getInstance().getResource();
			preparedStatement = connection
					.prepareStatement(SQL_QUERY_DELETE_GOODS);
			preparedStatement.setInt(1, numberGoods);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.error(e);
			return false;
		} finally {
			DAOUtils.closeStatement(preparedStatement);
			Pool.getInstance().returnResources(connection);
		}

		return true;
	}

	@Override
	public boolean editGoods(Goods goods) {
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		try {
			connection = Pool.getInstance().getResource();
			preparedStatement = connection
					.prepareStatement(SQL_QUERY_EDIT_GOODS);
			preparedStatement.setInt(5, goods.getNumberGoods());
			preparedStatement.setString(1, goods.getNameGoods());
			preparedStatement.setString(2, goods.getDescription());
			preparedStatement.setInt(3, goods.getPrice());
			preparedStatement.setString(4, goods.getImgGoods());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.error(e);
			return false;
		} finally {
			DAOUtils.closeStatement(preparedStatement);
			Pool.getInstance().returnResources(connection);
		}
		return true;
	}

	@Override
	public boolean addGoods(Goods goods) {
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		try {
			connection = Pool.getInstance().getResource();
			preparedStatement = connection
					.prepareStatement(SQL_QUERY_ADD_GOODS);
			preparedStatement.setString(1, goods.getNameGoods());
			preparedStatement.setString(2, goods.getCategory());
			preparedStatement.setString(3, goods.getDescription());
			preparedStatement.setInt(4, goods.getPrice());
			preparedStatement.setString(5, goods.getImgGoods());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.error(e);
			return false;
		} finally {
			DAOUtils.closeStatement(preparedStatement);
			Pool.getInstance().returnResources(connection);
		}
		return true;
	}

	@Override
	public Goods takeGoodsDetails(int goodsId) {
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		ResultSet resultSet = null;
		Goods goods = null;
		try {
			connection = Pool.getInstance().getResource();
			preparedStatement = connection
					.prepareStatement(SQL_QUERY_TAKE_GOODS_DETAILS);
			preparedStatement.setInt(1, goodsId);
			resultSet = preparedStatement.executeQuery();
			goods = initGoods(resultSet);
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			DAOUtils.closeStatement(preparedStatement);
			Pool.getInstance().returnResources(connection);
		}
		return goods;
	}

	private Goods initGoods(ResultSet resultSet) throws SQLException {
		Goods goods = null;
		while (resultSet.next()) {
			goods = new Goods();
			goods.setNumberGoods(resultSet.getInt(1));
			goods.setNameGoods(resultSet.getString(2));
			goods.setCategory(resultSet.getString(3));
			goods.setDescription(resultSet.getString(4));
			goods.setPrice(resultSet.getInt(5));
			goods.setImgGoods(resultSet.getString(6));
		}
		return goods;
	}

}
