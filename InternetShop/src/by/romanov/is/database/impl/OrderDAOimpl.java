package by.romanov.is.database.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import by.romanov.is.database.dao.OrderDAO;
import by.romanov.is.database.utils.DAOUtils;
import by.romanov.is.entity.Goods;
import by.romanov.is.entity.Order;
import by.romanov.is.entity.User;
import by.romanov.is.pool.Pool;

public class OrderDAOimpl implements OrderDAO {
	private static final Logger LOGGER = Logger.getLogger(OrderDAOimpl.class);
	private static final String SQL_QUERY_ADD_ORDER = "INSERT INTO `shopbase`.`order_info` (`sum`, `date_order`, `quantity_goods`, `login_customer`,`name_goods`, `payment`) VALUES (?, ?, ?, ?, ?, ? )";
	private static final String SQL_QUERY_TAKE_ORDER_USER = "SELECT number_order, login, sum, date_order, quantity_goods, name_goods, payment FROM user JOIN order_info ON user.Login = order_info.login_customer";
	private static final String SQL_QUERY_PAY_ORDER = "UPDATE order_info SET payment = 'Y' WHERE number_order = ?";
	private static final String SQL_QUERY_TAKE_LIST_ORDER = "SELECT number_order, sum, quantity_goods, name_goods, payment, date_order FROM order_info";
	private static final String SQL_QUERY_TAKE_USER_ORDER = "SELECT DISTINCT login_customer from order_info where name_goods=?";
	private static final String SQL_QUERY_INSERT_ORDER_HISTORY = "INSERT INTO order_history (number_order, sum, date_order, quantity_goods,login_customer, name_goods, payment) SELECT number_order, sum, date_order, quantity_goods,login_customer, name_goods, payment FROM order_info WHERE number_order=?";
	private static final String SQL_QUERY_DELETE_ORDER_INFO = "DELETE from order_info WHERE number_order=?";

	public boolean addOrder(Order order, User user, Goods goods) {
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		try {
			connection = Pool.getInstance().getResource();
			preparedStatement = connection
					.prepareStatement(SQL_QUERY_ADD_ORDER);

			preparedStatement.setInt(1, order.getSum());
			preparedStatement.setString(2, order.getDateOrder());
			preparedStatement.setInt(3, order.getQuantityGoods());
			preparedStatement.setString(4, user.getLogin());
			preparedStatement.setString(5, goods.getNameGoods());
			preparedStatement.setString(6, order.getPaymentOrder());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.error("SQLException", e);
			return false;
		} finally {
			DAOUtils.closeStatement(preparedStatement);
			Pool.getInstance().returnResources(connection);
		}

		return true;

	}

	@Override
	public List<Order> takeOrderUser(String login) {
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		List<Order> orderUser = new ArrayList<Order>();
		try {
			connection = Pool.getInstance().getResource();
			preparedStatement = connection
					.prepareStatement(SQL_QUERY_TAKE_ORDER_USER);
			ResultSet resultSet = preparedStatement
					.executeQuery(SQL_QUERY_TAKE_ORDER_USER);
			while (resultSet.next()) {
				String loginUser = resultSet.getString(2);
				if (login.equals(loginUser)) {
					Order order = new Order();
					order.setNumberOrder(resultSet.getInt(1));
					order.setSum(resultSet.getInt(3));
					order.setDateOrder(resultSet.getString(4));
					order.setQuantityGoods(resultSet.getInt(5));
					order.setNameGoods(resultSet.getString(6));
					order.setPaymentOrder(resultSet.getString(7));
					orderUser.add(order);
				}
			}
		} catch (SQLException e) {
			LOGGER.error("SQLException", e);
		} finally {
			DAOUtils.closeStatement(preparedStatement);
			Pool.getInstance().returnResources(connection);
		}
		return orderUser;
	}

	@Override
	public boolean payOrder(int numberOrder) {
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		try {
			connection = Pool.getInstance().getResource();
			preparedStatement = connection
					.prepareStatement(SQL_QUERY_PAY_ORDER);
			preparedStatement.setInt(1, numberOrder);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.error("SQLException", e);
			return false;
		} finally {
			DAOUtils.closeStatement(preparedStatement);
			Pool.getInstance().returnResources(connection);
		}
		return true;
	}

	@Override
	public List<Order> takeOrderList() {
		List<Order> orders = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = Pool.getInstance().getResource();
			preparedStatement = connection
					.prepareStatement(SQL_QUERY_TAKE_LIST_ORDER);
			ResultSet resultSet = preparedStatement.executeQuery();
			orders = initOrder(resultSet);
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			DAOUtils.closeStatement(preparedStatement);
			Pool.getInstance().returnResources(connection);

		}
		return orders;
	}

	private List<Order> initOrder(ResultSet resultSet) {
		List<Order> orders = new ArrayList<Order>();
		try {
			while (resultSet.next()) {
				Order order = new Order();
				order.setNumberOrder(resultSet.getInt(1));
				order.setSum(resultSet.getInt(2));
				order.setQuantityGoods(resultSet.getInt(3));
				order.setNameGoods(resultSet.getString(4));
				order.setPaymentOrder(resultSet.getString(5));
				order.setDateOrder(resultSet.getString(6));
				orders.add(order);
			}
		} catch (SQLException e) {
			LOGGER.error("SQLException", e);
		}
		return orders;
	}

	@Override
	public List<String> takeUserOrder(String name_goods) {
		List<String> users = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet;
		try {
			connection = Pool.getInstance().getResource();
			preparedStatement = connection
					.prepareStatement(SQL_QUERY_TAKE_USER_ORDER);
			preparedStatement.setString(1, name_goods);
			resultSet = preparedStatement.executeQuery();
			users = initUserOrder(resultSet);
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			DAOUtils.closeStatement(preparedStatement);
			Pool.getInstance().returnResources(connection);

		}
		return users;
	}

	private List<String> initUserOrder(ResultSet resultSet) {
		List<String> users = new ArrayList<String>();
		try {
			while (resultSet.next()) {
				users.add(resultSet.getString(1));
			}
		} catch (SQLException e) {
			LOGGER.error("SQLException", e);
		}

		return users;
	}

	@Override
	public boolean orderReady(int numberOrder) {
		Connection connection = null;
		PreparedStatement insertOrderHistory = null;
		PreparedStatement deleteOrderInfo = null;
		try {
			connection = Pool.getInstance().getResource();
			insertOrderHistory = connection
					.prepareStatement(SQL_QUERY_INSERT_ORDER_HISTORY);
			insertOrderHistory.setInt(1, numberOrder);
			insertOrderHistory.executeUpdate();
			deleteOrderInfo = connection
					.prepareStatement(SQL_QUERY_DELETE_ORDER_INFO);
			deleteOrderInfo.setInt(1, numberOrder);
			deleteOrderInfo.executeUpdate();
		} catch (SQLException e) {
			LOGGER.error(e);
			return false;
		} finally {
			DAOUtils.closeStatement(deleteOrderInfo);
			DAOUtils.closeStatement(insertOrderHistory);
			Pool.getInstance().returnResources(connection);
		}
		return true;
	}
}
