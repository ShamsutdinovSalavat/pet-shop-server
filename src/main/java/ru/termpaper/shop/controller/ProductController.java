package ru.termpaper.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.termpaper.shop.model.*;
import ru.termpaper.shop.service.ProductService;

import java.util.List;

@RestController
@RequestMapping(
		path = "/products",
		produces = "application/json"
)
@CrossOrigin
public class ProductController {

	@Autowired
	private ProductService productService;


	@GetMapping()
	public List<Product> getAll() {
		return this.productService.getAll();
	}

	@DeleteMapping(value = "{id}")
	public ResponseEntity delete(@PathVariable Long id) {
		this.productService.delete(id);
		return ResponseEntity.ok().build();
	}

	@GetMapping("{id}")
	public Product getById(@PathVariable Long id) {
		return this.productService.getById(id);
	}

	@RequestMapping(value = "/keyboard", method = {RequestMethod.PATCH, RequestMethod.POST})
	public ResponseEntity saveKeyboard(@RequestBody Keyboard keyboard) {
		return saveProduct(keyboard);
	}

	@RequestMapping(value = "/mouse", method = {RequestMethod.PATCH, RequestMethod.POST})
	public ResponseEntity saveMouse(@RequestBody Mouse mouse) {
		return saveProduct(mouse);
	}

	@RequestMapping(value = "/monitor", method = {RequestMethod.PATCH, RequestMethod.POST})
	public ResponseEntity saveMonitor(@RequestBody Monitor monitor) {
		return saveProduct(monitor);
	}

	@RequestMapping(value = "/systemUnit", method = {RequestMethod.PATCH, RequestMethod.POST})
	public ResponseEntity saveSystemUnit(@RequestBody SystemUnit systemUnit) {
		return saveProduct(systemUnit);
	}

	private ResponseEntity saveProduct(Product product) {
		this.productService.save(product);
		return ResponseEntity.ok().build();
	}

}
