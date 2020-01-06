package ru.termpaper.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.termpaper.shop.model.Monitor;

public interface MonitorRepository extends JpaRepository<Monitor, Long> {
}
