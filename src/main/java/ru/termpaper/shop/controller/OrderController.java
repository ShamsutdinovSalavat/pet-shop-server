package ru.termpaper.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.termpaper.shop.model.Order;
import ru.termpaper.shop.service.OrderService;

import java.util.List;

@RestController
@RequestMapping(
		path = "/order",
		produces = "application/json"
)
@CrossOrigin
public class OrderController {

	@Autowired
	private OrderService orderService;

	@PostMapping
	public ResponseEntity save(@RequestBody Order order) {
		this.orderService.save(order);
		return ResponseEntity.ok().build();
	}

	@GetMapping(value = "{id}")
	public Order getById(@PathVariable Long id) {
		return this.orderService.getById(id);
	}

	@DeleteMapping("{id}")
	public ResponseEntity delete(@PathVariable Long id) {
		this.orderService.deleteById(id);
		return ResponseEntity.ok().build();
	}

	@GetMapping
	public List<Order> getAll() {
		return this.orderService.getAll();
	}
}
