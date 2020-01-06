package ru.termpaper.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.termpaper.shop.model.Keyboard;

public interface KeyboardRepository extends JpaRepository<Keyboard, Long> {
}
