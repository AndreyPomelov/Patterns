package com.example.crm.model.repository;

import com.example.crm.model.entity.Unit;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Репозиторий отделов (подразделений)
 */
public interface UnitRepository extends JpaRepository<Unit, Integer> {
}
