package ru.termpaper.shop.service;

import ru.termpaper.shop.model.Product;

import java.util.List;

public interface ProductService {

	List<Product> getAll();

	Product getById(Long id);

	void save(Product product);

	void delete(Long id);
}
