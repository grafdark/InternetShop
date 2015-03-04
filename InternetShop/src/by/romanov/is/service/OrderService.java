package by.romanov.is.service;

import java.util.List;

import by.romanov.is.database.dao.OrderDAO;
import by.romanov.is.database.impl.OrderDAOimpl;
import by.romanov.is.entity.Goods;
import by.romanov.is.entity.Order;
import by.romanov.is.entity.User;

public class OrderService {
	private OrderDAO orderDAO;

	public OrderService() {
		orderDAO = new OrderDAOimpl();
	}

	public boolean addOrder(Order order, User user, Goods goods) {
		return orderDAO.addOrder(order, user, goods);

	}

	public List<Order> takeOrderUser(String login) {
		return orderDAO.takeOrderUser(login);

	}

	public boolean payOrder(int numberOrder) {
		return orderDAO.payOrder(numberOrder);
	}

	public List<Order> takeOrderList() {
		return orderDAO.takeOrderList();

	}
	public List<String> takeUserOrder(String name_goods){
		return orderDAO.takeUserOrder(name_goods);
	}
	
	public boolean orderReady(int number_order){
		return orderDAO.orderReady(number_order);
	}
}
