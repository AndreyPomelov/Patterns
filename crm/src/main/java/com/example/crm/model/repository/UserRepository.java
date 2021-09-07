package com.example.crm.model.repository;

import com.example.crm.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Репозиторий пользователей
 */
public interface UserRepository extends JpaRepository<User, Integer> {
}
