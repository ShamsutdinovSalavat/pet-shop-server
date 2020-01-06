package ru.termpaper.shop.service;

import ru.termpaper.shop.model.Order;

import java.util.List;

public interface OrderService {
	void save(Order order);
	List<Order> getAll();
	Order getById(Long id);

	void deleteById(Long id);
}
