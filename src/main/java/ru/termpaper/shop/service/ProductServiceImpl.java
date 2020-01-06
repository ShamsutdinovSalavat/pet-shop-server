package ru.termpaper.shop.service;

import org.springframework.stereotype.Service;
import ru.termpaper.shop.model.*;
import ru.termpaper.shop.repository.*;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

	private ProductRepository productRepository;
	private MonitorRepository monitorRepository;
	private MouseRepository mouseRepository;
	private KeyboardRepository keyboardRepository;
	private SystemUnitRepository systemUnitRepository;
	private CartRepository cartRepository;

	public ProductServiceImpl(ProductRepository productRepository,
	                          MonitorRepository monitorRepository,
	                          MouseRepository mouseRepository,
	                          KeyboardRepository keyboardRepository,
	                          SystemUnitRepository systemUnitRepository,
	                          CartRepository cartRepository) {
		this.productRepository = productRepository;
		this.monitorRepository = monitorRepository;
		this.mouseRepository = mouseRepository;
		this.keyboardRepository = keyboardRepository;
		this.systemUnitRepository = systemUnitRepository;
		this.cartRepository = cartRepository;
	}

	@Override
	public List<Product> getAll() {
		return productRepository.findAll();
	}

	@Override
	public Product getById(Long id) {
		return this.productRepository.findById(id).get();
	}

	@Override
	public void save(Product product) {
		ProductType type = product.getProductType();

		switch (type) {
			case KEYBOARD:
				keyboardRepository.save((Keyboard) product);
				break;
			case MOUSE:
				mouseRepository.save((Mouse) product);
				break;
			case MONITOR:
				monitorRepository.save((Monitor) product);
				break;
			case SYSTEM_UNIT:
				systemUnitRepository.save((SystemUnit) product);
				break;
			default:
				productRepository.save(product);
		}
	}

	@Override
	public void delete(Long id) {
		Product product = this.productRepository.getOne(id);
		for (CartItem item : product.getItems()) {
			this.cartRepository.deleteById(item.getId());
		}
		this.productRepository.deleteById(id);
	}
}
