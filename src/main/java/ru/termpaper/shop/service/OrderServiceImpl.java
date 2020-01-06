package ru.termpaper.shop.service;

import org.springframework.stereotype.Service;
import ru.termpaper.shop.model.CartItem;
import ru.termpaper.shop.model.Order;
import ru.termpaper.shop.model.Product;
import ru.termpaper.shop.repository.CartRepository;
import ru.termpaper.shop.repository.OrderRepository;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

	private OrderRepository orderRepository;
	private CartRepository cartRepository;
	private ProductService productService;

	public OrderServiceImpl(OrderRepository orderRepository,
	                        CartRepository cartRepository,
	                        ProductService productService) {
		this.orderRepository = orderRepository;
		this.cartRepository = cartRepository;
		this.productService = productService;
	}

	@Override
	public void save(Order order) {
		Order save = this.orderRepository.save(order);

		List<CartItem> items = order.getItems();
		items.forEach(cartItem -> {
			cartItem.setOrder(save);
			decreaseProductAmount(cartItem.getProduct(), cartItem.getAmount());
		});
		this.cartRepository.saveAll(items);
	}

	@Override
	public List<Order> getAll() {
		return this.orderRepository.findAll();
	}

	@Override
	public Order getById(Long id) {
		return this.orderRepository.findById(id).get();
	}

	@Override
	public void deleteById(Long id) {
		Order order = this.orderRepository.getOne(id);
		for (CartItem item : order.getItems()) {
			this.cartRepository.deleteById(item.getId());
		}

		this.orderRepository.deleteById(id);

	}

	private void decreaseProductAmount(Product product, Integer cartItemAmount) {
		Product fetchedProduct = this.productService.getById(product.getId());
		Integer amount = fetchedProduct.getAmount();
		if (amount < cartItemAmount) {
			fetchedProduct.setAmount(0);
		} else {
			fetchedProduct.setAmount(amount - cartItemAmount);
		}

		this.productService.save(fetchedProduct);


	}
}
