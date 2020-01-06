package ru.termpaper.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.termpaper.shop.model.CartItem;

public interface CartRepository extends JpaRepository<CartItem, Long> {
}
