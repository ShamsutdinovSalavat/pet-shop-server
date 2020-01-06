package ru.termpaper.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.termpaper.shop.model.Mouse;

public interface MouseRepository extends JpaRepository<Mouse, Long> {
}
