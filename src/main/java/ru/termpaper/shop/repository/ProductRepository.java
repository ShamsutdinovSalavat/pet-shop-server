package ru.termpaper.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.termpaper.shop.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
