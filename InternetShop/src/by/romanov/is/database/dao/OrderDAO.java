package by.romanov.is.database.dao;

import java.util.List;

import by.romanov.is.entity.Goods;
import by.romanov.is.entity.Order;
import by.romanov.is.entity.User;

public interface OrderDAO {
	boolean addOrder(Order order, User user, Goods goods);

	List<Order> takeOrderUser(String login);

	boolean payOrder(int numberOrder);

	List<Order> takeOrderList();

	List<String> takeUserOrder(String name_goods);
	
	boolean orderReady(int number_order);
}
