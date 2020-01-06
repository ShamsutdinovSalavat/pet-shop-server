package ru.termpaper.shop.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.termpaper.shop.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
